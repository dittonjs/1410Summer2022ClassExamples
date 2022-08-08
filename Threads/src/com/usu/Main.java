package com.usu;

import java.util.ArrayList;

public class Main {
    static Integer result = 0;

    public static void main(String[] args) throws InterruptedException {
	    // write your code here
        doSomethingAfter5Seconds(() -> {
//            synchronized (result) {
                result = 10;
                System.out.println(result);
//            }
        });
        doSomethingAfter5Seconds(() -> {
//            synchronized (result) {
                result = 15;
                System.out.println(result);
//            }
        });

    }

    interface CustomCallback {
        void call();
    }

    public static void doSomethingAfter5Seconds(CustomCallback callback) {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.call();
        }).start();
    }
}
