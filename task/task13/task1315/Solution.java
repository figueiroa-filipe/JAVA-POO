package com.codegym.task.task13.task1315;

/* 
Tom, Jerry and Spike

*/

public class Solution {
    public static void main(String[] args) {

    }

    // Can move
    public interface CanMove {
        void move();
    }

    // Can be eaten
    public interface Edible {
        void beEaten();
    }

    // Can eat
    public interface CanEat {
        void eat();
    }

    public static class Dog implements CanEat, CanMove{

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }
    }
    public static class Cat implements CanMove, CanEat, Edible{
        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
    public static class Mouse implements Edible, CanMove{
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
}