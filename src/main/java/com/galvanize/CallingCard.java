package com.galvanize;

public class CallingCard {
    private int centsPerMinute;
    private float minutesLeft;
    public CallingCard(int centsPerMinute) {
        this.centsPerMinute = centsPerMinute;
    }

    public void addDollars(int dollars) {
        this.minutesLeft += (dollars * 100 / centsPerMinute);
    }

    public float getRemainingMinutes() {
        return this.minutesLeft;
    }

    public void useMinutes(int minutes) {
        float result = this.minutesLeft - minutes;
        this.minutesLeft = result < 0 ? 0 : result;
    }
}
