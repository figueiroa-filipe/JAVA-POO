package com.codegym.task.task15.task1528;

/* 
OOP: The Euro is money too

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Euro().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        abstract Object getAmount();
    }

    // Add your code below
    public static class Euro extends Money {
        private double amount = 123d;

        @Override
        Object getAmount() {
            return amount;
        }

        public Euro getMoney() {
            return this;
        }
    }
}
