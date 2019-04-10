package com.xdclass.test;

public class ThreadDebug {
    private static ThreadDebug instance;


    private ThreadDebug() {
    }

    public static ThreadDebug getInstance() {

        if (instance == null) {
            synchronized (ThreadDebug.class) {
                instance = new ThreadDebug();
                //在控制台打印出对象
                System.out.println("instance = " + instance);
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                ThreadDebug.getInstance();
            }).start();
        }
    }
}
