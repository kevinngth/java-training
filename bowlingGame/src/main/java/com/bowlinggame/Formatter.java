package com.bowlinggame;

import java.util.List;

public class Formatter {
    private static final String NEW_LINE = "\n";
    private static final String DIVIDER = " | ";
    private static final String STRIKE = "X";
    private static final String NIL = "-";
    private static final String SPARE = "/";
    private static final String SPACE = " ";
    private static final String DOUBLE_SPACE = "  ";
    private static final String SPACER = "        ";
    private static final String END = "    |";
    private static final String PLAYER_NAME = "Player 1";
    private static final int STRIKE_SCORE = 10;
    private static final int LAST_FRAME = 9;
    private static final int NORMAL_WIDTH = 5;


    public String toString( List<Frame> frames ) {
        String result = frames.isEmpty() ? getTemplate() : getTemplate() + getFrameScores( frames ) + getAccumulatedScores( frames );
        System.out.println( result );
        return result;
    }

// HEADER SECTION

    private String getTemplate() {
        return getHeader() + NEW_LINE + getBorder() + NEW_LINE;
    }

    private String getHeader() {
        String header = "Name    ";
        for (Integer i = 1; i <= LAST_FRAME + 1; i++) {
            header = header + DIVIDER + DOUBLE_SPACE + i.toString() + DOUBLE_SPACE;
        }
        header = header + END;
        return header;
    };

    private String getBorder() {
        String border = "";
        for (int i = 0; i < 94; i++ ) {
            border += NIL;
        }
        return border;
    }

// FRAME SCORES SECTION

    private String getFrameScores( List<Frame> frames ) {
        return PLAYER_NAME + DIVIDER + calculateFrameScores( frames ) + NEW_LINE;
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

// ACCUMULATED SCORE SECTION

    private String getAccumulatedScores( List<Frame> frames ) {
        String toPrint = SPACER + DIVIDER;
        int accumulator = 0;
        for (int i = 0; i < frames.size() ; i++) {
            Frame currentFrame = frames.get( i );
//            if ( currentFrame.isStrike() && i + 1 < frames.size() ) {
//                accumulator += STRIKE_SCORE + ( frames.get( i + 1 ).isStrike() ? STRIKE_SCORE + frames.get( i + 2 ).getFirstRoll() : frames.get( i + 1 ).calculateScore() );
//                toPrint += padScore( accumulator, NORMAL_WIDTH );
//            } else if ( currentFrame.isSpare() && i + 1 < frames.size() ) {
//                accumulator += STRIKE_SCORE + frames.get( i + 1 ).getFirstRoll();
//                toPrint += padScore( accumulator, NORMAL_WIDTH);
//            } else {
                accumulator += currentFrame.calculateScore();
                toPrint += i == LAST_FRAME ? padScore( accumulator, LAST_FRAME ) : padScore( accumulator, NORMAL_WIDTH );
//            }
        }
        return toPrint;
    }

    private String padScore( int score, int availableSpacing ) {
        String result = String.valueOf( score );
        availableSpacing -= result.length();
        while ( availableSpacing > 0 ) {
            result = availableSpacing % 2 == 0 ? SPACE + result : result + SPACE;
            availableSpacing--;
        }
        result += DIVIDER;
        return result;
    }

}
