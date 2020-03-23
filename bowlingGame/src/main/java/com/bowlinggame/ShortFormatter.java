package com.bowlinggame;

import java.util.List;

public class ShortFormatter extends Formatter {
    private static final String FRAME_TITLE = "Frames =";
    private static final String COMMA = ",";
    private final String header = "Game   =";
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
    protected String getFrameScores( List<Frame> frames ) {
        return FRAME_TITLE + calculateFrameScores( frames );
    }

    private String calculateFrameScores( List<Frame> frames ) {
        String frameScore = "";
        for (Frame frame : frames) {
            frameScore += DIVIDER + frame.getFirstRoll() + COMMA + frame.getSecondRoll();
        }
        return frames.size() > LAST_FRAME ? frameScore + COMMA + frames.get( LAST_FRAME ).getSpecialRoll() + DIVIDER : frameScore;
    }
}
