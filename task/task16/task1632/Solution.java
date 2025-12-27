package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());


    }
    public static void main(String[] args) {

    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true){}
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            if (isInterrupted()) System.out.println(InterruptedException.class.getSimpleName());
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Hurray");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
            }
        }
    }
    public static class Thread4 extends Thread implements Message{
        private static boolean isCalled = false;
        @Override
        public void run() {
            while (!isCalled){

            }
            Thread.interrupted();
        }

        @Override
        public void showWarning() {
            isCalled = true;
        }
    }
    public static class Thread5 extends Thread{
        @Override
        public void run() {
            int soma = 0;
            while (true) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                    String s = reader.readLine();
                    if (s.equals("N")) {
                        break;
                    }
                    soma += Integer.parseInt(s);
                } catch (IOException e) {
                }
            }
            System.out.println(soma);
        }
    }
}