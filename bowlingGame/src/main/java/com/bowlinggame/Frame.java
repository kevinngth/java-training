package com.bowlinggame;

public class Frame {
    private int firstRoll;
    private int secondRoll;
    private int specialRoll = 0;
    public Frame( int firstRoll, int secondRoll ) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame( int firstRoll, int secondRoll, int specialRoll ) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.specialRoll = specialRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getTotal() {
        return firstRoll + secondRoll;
    }

    public boolean isSpare() {
        if ( firstRoll != 10 && this.getTotal() == 10 ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStrike() {
        if ( this.firstRoll == 10 ) {
            return true;
        } else {
            return false;
        }
    }

    public int tenthFrameBonusScore() {
        return this.specialRoll;
    }
}
