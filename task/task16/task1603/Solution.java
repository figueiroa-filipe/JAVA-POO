package com.codegym.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
A list and some threads

*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        //write your code here
        SpecialThread thread1 = new SpecialThread();
        SpecialThread thread2 = new SpecialThread();
        SpecialThread thread3 = new SpecialThread();
        SpecialThread thread4 = new SpecialThread();
        SpecialThread thread5 = new SpecialThread();

        Thread realThread1 = new Thread(thread1);
        Thread realThread2 = new Thread(thread2);
        Thread realThread3 = new Thread(thread3);
        Thread realThread4 = new Thread(thread4);
        Thread realThread5 = new Thread(thread5);

        list.add(realThread1);
        list.add(realThread2);
        list.add(realThread3);
        list.add(realThread4);
        list.add(realThread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("This is the run method inside SpecialThread");
        }
    }
}
