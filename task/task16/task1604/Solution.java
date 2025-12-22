package com.codegym.task.task16.task1604;

/* 
Displaying a stack trace

*/

public class Solution {
    public static class SpecialThread implements Runnable{
        @Override
        public void run() {
            for (StackTraceElement e : Thread.currentThread().getStackTrace())
                System.out.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }
}
