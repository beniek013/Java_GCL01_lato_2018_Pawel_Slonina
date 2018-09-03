package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    Worker worker1 = new Worker("Paweł");
        worker1.setListener(new WokrerListenerClass());
	    worker1.start();
	    worker1.start();
        //System.out.println(worker1.isStarted());
	    worker1.stop();
	    worker1.stop();
        worker1.start();
        worker1.enqueueTask("t1", new TaskOne());
        worker1.enqueueTask("t2", new TaskOne());
        worker1.enqueueTask("t3", new TaskOne());
    }
}
