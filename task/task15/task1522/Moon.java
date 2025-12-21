package com.codegym.task.task15.task1522;

public class Moon implements Planet{

    private Moon(){
    }

    public static Moon getInstance() {
        if (instance == null) instance = new Moon();
        return instance;
    }

    private static Moon instance;
}
