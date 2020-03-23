package com.bowlinggame;

import java.util.List;

public class ShortFormatter extends Formatter {
    private static final String HEADER = "Game   =";
    private static final String FRAME_TITLE = "Frames =";
    private static final String COMMA = ",";
    private static final String SCORE_TITLE = "Scores =";
    private static final int NORMAL_WIDTH = 3;
    private static final int SPECIAL_WIDTH = 5;

// HEADER SECTION

    protected String getTemplate() {
        return HEADER + NEW_LINE;
    }


// FRAME SCORES SECTION

    protected String getFrameScores( List<Frame> frames ) {
        return FRAME_TITLE + calculateFrameScores( frames ) + NEW_LINE;
    }

    private String calculateFrameScores( List<Frame> frames ) {
        String frameScore = "";
        for (Frame frame : frames) {
            frameScore += DIVIDER + frame.getFirstRoll() + COMMA + frame.getSecondRoll();
        }
        return frames.size() > LAST_FRAME ? frameScore + COMMA + frames.get( LAST_FRAME ).getSpecialRoll() + DIVIDER : frameScore;
    }


// ACCUMULATED SCORE SECTION

    protected String getAccumulatedScores( List<Frame> frames ) {
        String toPrint = SCORE_TITLE + DIVIDER;
        int accumulator = 0;
        for (int i = 0; i < frames.size() ; i++) {
            Frame currentFrame = frames.get( i );
            accumulator += currentFrame.calculateScore();
            toPrint += i == LAST_FRAME ? padScore( accumulator, SPECIAL_WIDTH ) : padScore( accumulator, NORMAL_WIDTH );
        }
        return toPrint;
    }
}
