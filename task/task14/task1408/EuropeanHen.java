package com.codegym.task.task14.task1408;

class EuropeanHen extends Hen implements Continent {
    @Override
    int getMonthlyEggCount() {
        return 2000;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + this.EUROPE + "."
                + " I lay " + this.getMonthlyEggCount() + " eggs a month.";
    }
}
