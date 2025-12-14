package com.codegym.task.task14.task1413;

public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    private Computer(Keyboard ke, Mouse mo, Monitor mt) {
        this.keyboard = ke;
        this.mouse = mo;
        this.monitor = mt;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
