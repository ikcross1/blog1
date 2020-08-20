package com.nnxy.blog.webconfig;

public class Homework1 {
    static  int a = 1000;
    public static void main(String[] args) {
        new Thread(new T1()).start();
        new Thread(new T1()).start();
        new Thread(new T1()).start();
    }

    static class T1 implements Runnable{
        @Override
        public synchronized void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(a>0){
                a--;
                System.out.println(Thread.currentThread().getName()+":"+(a));

            }

        }
    }


}


