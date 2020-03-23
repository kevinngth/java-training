package com.bowlinggame;

import java.util.List;

public class LongFormatter extends Formatter {
    private static final String STRIKE = "X";
    private static final String NIL = "-";
    private static final String SPARE = "/";
    private static final String DOUBLE_SPACE = "  ";
    private static final String END = "    |";
    private static final String PLAYER_NAME = "Player 1";
    private String header = "Name    ";
    private String scoreTitle = "        ";
    private int specialWidth = 9;
    private int normalWidth = 5;

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
        String header = "Name    ";
        for (int i = 1; i <= LAST_FRAME + 1; i++) {
            header += DIVIDER + DOUBLE_SPACE + i + DOUBLE_SPACE;
        }
        header = header + END;
        return header + NEW_LINE + getBorder();
    };

    private String getBorder() {
        String border = "";
        for (int i = 0; i < 94; i++ ) {
            border += NIL;
        }
        return border;
    }

// FRAME SCORES SECTION

    protected String getFrameScores( List<Frame> frames ) {
        return PLAYER_NAME + DIVIDER + calculateFrameScores( frames );
    }

    private String calculateFrameScores( List<Frame> frames ) {
        String frameScore = "";
        for (Frame frame : frames) {
            if ( frame.isStrike() ) {
                frameScore += printFrame( STRIKE, NIL );
            } else if ( frame.isSpare() ) {
                frameScore += printFrame( toStringScore( frame.getFirstRoll() ), SPARE );
            } else {
                frameScore += printFrame( toStringScore( frame.getFirstRoll() ), toStringScore( frame.getSecondRoll() ) );
            }
        }
        return frames.size() > LAST_FRAME ? frameScore + toStringScore( frames.get( LAST_FRAME ).getSpecialRoll() ) + DIVIDER : frameScore;
    }

    private String printFrame( String score1, String score2 ) {
        return score1 + DIVIDER + score2 + DIVIDER;
    }

    private String toStringScore( int score ) {
        return score == 0 ? NIL : String.valueOf(score);
    }
}
