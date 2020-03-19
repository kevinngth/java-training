package com.bowlinggame;

public class Frame {
    private int firstRoll;
    private int secondRoll;
    private int specialRoll = 0;
    private Frame previousFrame;
    public Frame( int firstRoll, int secondRoll, Frame previousFrame ) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.previousFrame = previousFrame;
    }

    public Frame( int firstRoll, int secondRoll, int specialRoll, Frame previousFrame ) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.specialRoll = specialRoll;
        this.previousFrame = previousFrame;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getTotal() {
        return firstRoll + secondRoll;
    }

    public boolean isSpare() {
        return firstRoll != 10 && this.getTotal() == 10;
    }

    public boolean isStrike() {
        return this.firstRoll == 10;
    }

    private boolean isConsecutiveStrike() {
        return previousFrame != null && previousFrame.isStrike();
    }

    public int tenthFrameBonusScore() {
        if ( isStrike() ) {
            return this.specialRoll + 10;
        }
        return this.specialRoll;
    }

    public int getFrameScore() {
        int score = 0;
        if ( previousFrame == null ) {
            score = getTotal();
        } else {
            if (previousFrame.isStrike()) {
                if ( previousFrame.isConsecutiveStrike() ) {
                    score = getTotal() + getFirstRoll() + 10;
                } else {
                    score = getTotal() + getTotal();
                }
            } else if (previousFrame.isSpare()) {
                score = getTotal() + getFirstRoll();
            } else {
                score = getTotal();
            }
        }
        if ( specialRoll != 0 ) {
            score += tenthFrameBonusScore();
        }
        return score;
    }
}