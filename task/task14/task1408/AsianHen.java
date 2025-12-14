package com.codegym.task.task14.task1408;

class AsianHen extends Hen implements Continent {
    @Override
    int getMonthlyEggCount() {
        return 3000;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + this.ASIA + "."
                + " I lay " + this.getMonthlyEggCount() + " eggs a month.";
    }
}
