package com.company;

public class TaskOne implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {
        Thread.sleep(1000);
    }
}
