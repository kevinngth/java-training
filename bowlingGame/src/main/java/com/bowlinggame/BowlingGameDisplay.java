package com.bowlinggame;

public class BowlingGameDisplay {
    private String header = "Name     |   1   |   2   |   3   |  4    |   5   |  6    |   7   |   8   |   9   |    10     |";
    private BowlingGame game;
    private String newLine = "\n";

    public BowlingGameDisplay(BowlingGame game) {
        this.game = game;
    };

    public String display() {
        String details = this.header + newLine + this.border() ;
        System.out.println( details );
        return details;
    }

    private String border() {
        String border = "";
        for (int i = 0; i < 94; i++ ) {
            border += "-";
        }
        return border;
    }
}
