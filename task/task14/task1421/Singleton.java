package com.codegym.task.task14.task1421;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        if (instance != null) return;
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.instance;
    }
}
