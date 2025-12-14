package com.codegym.task.task14.task1408;

public class AfricanHen extends Hen implements Continent {
    @Override
    int getMonthlyEggCount() {
        return 2900;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + this.AFRICA + "."
                + " I lay " + this.getMonthlyEggCount() + " eggs a month.";
    }
}
