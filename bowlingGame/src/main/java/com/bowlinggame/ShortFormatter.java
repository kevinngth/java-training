package com.bowlinggame;

public class ShortFormatter extends Formatter {
    private static final String COMMA = ",";
    private final String header = "Game   =";
    private final String framesTitle = "Frames =";
    private final String scoreTitle = "Scores =";
    private final int specialWidth = 5;
    private final int normalWidth = 3;

    @Override
    public String getScoreTitle() {
        return scoreTitle;
    }

    @Override
    public int getSpecialWidth() {
        return specialWidth;
    }

    @Override
    public int getNormalWidth() {
        return normalWidth;
    }

    @Override
    protected String getHeader() {
        return header;
    }

// FRAME SCORES SECTION

    @Override
    protected String getFramesTitle() {
        return framesTitle;
    }

    @Override
    protected String printFrame( Frame frame ) {
        String result = "";
        result += frame.getFirstRoll() + COMMA + frame.getSecondRoll() + ( frame.getSpecialRoll() == -1 ? "" : COMMA + frame.getSpecialRoll() ) + DIVIDER;
        return result;
    }
}
