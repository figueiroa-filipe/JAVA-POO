package com.codegym.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Decrease").start();
        new Thread(new CountUpRunnable(), "Increase").start();
    }

    public static class CountUpRunnable implements Runnable{
        private int countUp = 1;
        @Override
        public void run() {
            while (countUp <= number)
            {
                System.out.println(toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //write your code here

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countUp++;
        }
    }


    public static class CountdownRunnable implements Runnable {
        private int countdownIndex = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countdownIndex -= 1;
                    if (countdownIndex == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }
}
