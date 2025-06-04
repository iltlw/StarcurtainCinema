package com.buka.test;

import java.util.concurrent.Callable;

public class MyCallable implements Runnable {

    public MyCallable() {
        System.out.println("123");
    }


    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
