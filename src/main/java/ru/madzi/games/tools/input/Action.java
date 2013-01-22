package ru.madzi.games.tools.input;


public class Action {

    private String name;

    private Behavior behavior;

    private int amount;

    private State state;

    public Action(String name) {
        this(name, Behavior.NORMAL);
    }

    public Action(String name, Behavior behavior) {
        this.name = name;
        this.behavior = behavior;
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        state = State.RELEASED;
        amount = 0;
    }

    public synchronized void tap() {
        press();
        release();
    }

    public synchronized void press() {
        press(1);
    }

    public synchronized void press(int amount) {
        if (state != State.WAITING_FOR_RELEASE) {
            this.amount += amount;
            state = State.PRESSED;
        }
    }

    public synchronized void release() {
        state = State.RELEASED;
    }

    public synchronized boolean isPressed() {
        return (getAmount() != 0);
    }

    public synchronized int getAmount() {
        int retVal = amount;
        if (retVal != 0) {
            if (state == State.RELEASED) {
                amount = 0;
            }
            else if (behavior == Behavior.DETECT_INITIAL_PRESS_ONLY) {
                state = State.WAITING_FOR_RELEASE;
                amount = 0;
            }
        }
        return retVal;
    }

    public enum Behavior {
        NORMAL,
        DETECT_INITIAL_PRESS_ONLY;
    }

    public enum State {
        RELEASED,
        PRESSED,
        WAITING_FOR_RELEASE;
    }

}
