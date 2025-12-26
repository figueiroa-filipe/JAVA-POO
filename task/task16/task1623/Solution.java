package com.codegym.task.task16.task1623;

/* 
Creating threads recursively

*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = -1;

    public static void main(String[] args) {
        new GenerateThread();
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }

        @Override
        public void run() {
            if (createdThreadCount <= count)
            {
                GenerateThread thread = new GenerateThread();
                System.out.println(thread);
            }
        }
    }
}
