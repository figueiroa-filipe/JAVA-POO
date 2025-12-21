package com.codegym.task.task15.task1520;

/* 
Brain training

*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements CanFly, CanMove {
        @Override
        public void doAction() {
            System.out.println("Flying");
        }

        @Override
        public void doAnotherAction() {
            System.out.println("Moving");
        }
    }

    public static class Util implements CanFly, CanMove {
        static void fly(CanFly animal) {
            animal.doAction();
        }

        static void move(CanMove animal) {
            animal.doAnotherAction();
        }

        @Override
        public void doAction() {

        }

        @Override
        public void doAnotherAction() {

        }
    }

    public interface CanFly {
        void doAction();
    }

    public interface CanMove {
        void doAnotherAction();
    }
}
