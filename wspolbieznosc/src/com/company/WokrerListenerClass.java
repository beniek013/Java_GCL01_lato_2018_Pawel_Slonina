package com.company;

public class WokrerListenerClass implements WorkerListener {

    @Override
    public void onWorkerStarted() {
        System.out.println("Work started!");
    }

    @Override
    public void onWorkerStopped() {
        System.out.println("Work stopped!");
    }

    @Override
    public void onTaskStarted(int taskNumber, String taskName) {
        System.out.println("Task "+ taskNumber+": "+taskName+" starting");
    }

    @Override
    public void onTaskCompleted(int taskNumber, String taskName) {
        System.out.println("Task "+ taskNumber + ": " +taskName+" stopping");
    }

}
