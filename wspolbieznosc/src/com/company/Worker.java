package com.company;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Worker implements Runnable {

    private String name;
    private AtomicBoolean isWorking, isStarted;
    private volatile boolean running = true;
    private LinkedHashMap<String, Task> tasks;
    private Thread thread;
    private WorkerListener workerListener;

    public Worker(String name) {
        this.name = name;
        thread = new Thread(this);
        tasks = new LinkedHashMap<String, Task>();
        isWorking = new AtomicBoolean();
        isStarted = new AtomicBoolean();
        running = true;
    }

    //dodaje kolejne zadanie do wykonania
    void enqueueTask(String taskName, Task task)
    {
        tasks.put(taskName, task);
    }

    //uruchamia sekwencyjne wykonywanie kolejnych task'ów w nowym wątku; jako pierwsza operacja w nowym wątku wykonuje się onWorkerStarted
    void start(){
        if(!isStarted.get() && !isWorking.get()) {
            workerListener.onWorkerStarted();
            isStarted.set(true);
            isWorking.set(true);
            running = true;
            thread.start();
        }
        else if(isStarted.get() && !isWorking.get()){
            workerListener.onWorkerStarted();
            isWorking.set(true);
            running = true;
        }
    }

    //wysyła sygnał przerwania Workera; wykonanie tej metody moze spowodować bezpieczne przerwanie wątku - tzn. nie wolno przerywać
    //tasku z poziomu wątku w trakcie jego wykonywania; jako ostatnio operacja w wątku wykonuje się on WorkerStoped
    void stop(){
        if(isWorking.get()) {
            isWorking.set(false);
            workerListener.onWorkerStopped();
            running = false;
        }
    }

    //przepisuje zestaw event-ow wykonywanych przez Worker
    void setListener(WorkerListener workerListener){
        this.workerListener = workerListener;
    }


    //informuje o tym czy Worker jest obecnie uruchomiony
    boolean isStarted(){
        return isStarted.get();
    }

    //informuje o tym czy Worker wykonuje obecnie jakieś zadania
    boolean isWorking(){
        return isWorking.get();
    }


    public void run() {
        isWorking.set(true);
        Thread.currentThread().setName("Worker " + name + " Thread");
        //System.out.println(Thread.currentThread().getName());
        int i=1;
        while(running){
            try {
                if (!tasks.isEmpty()) {
                    String name = tasks.keySet().iterator().next();
                    Task task = tasks.remove(name);
                    workerListener.onTaskStarted(i, name);
                    task.run(i);
                    workerListener.onTaskCompleted(i, name);
                }
            } catch (InterruptedException e) {
                System.err.println("Task " + i + ": " + name + " was interrupted.");
                running = false;
            }
            i++;
        }
    }
}
