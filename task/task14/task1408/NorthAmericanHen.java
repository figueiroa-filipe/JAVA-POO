package com.codegym.task.task14.task1408;

class NorthAmericanHen extends Hen implements Continent {
    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + this.NORTHAMERICA + "."
                + " I lay " + this.getMonthlyEggCount() + " eggs a month.";
    }

    @Override
    int getMonthlyEggCount() {
        return 1200;
    }
}
