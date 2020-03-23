package com.bowlinggame;

import java.util.List;

public abstract class Formatter {

    static final String DIVIDER = " | ";
    static final String NEW_LINE = "\n";
    static final String SPACE = " ";
    static final int LAST_FRAME = 9;

    public String toString( List<Frame> frames ) {
        String result = frames.isEmpty() ? getHeader() : getHeader() + NEW_LINE + getFrameScores( frames ) + NEW_LINE + getAccumulatedScores( frames );
        System.out.println( result );
        return result;
    }

// HEADER SECTION

    protected abstract String getHeader();

// FRAME SCORES SECTION

    protected abstract String getFrameScores( List<Frame> frames );

// ACCUMULATED SCORE SECTION

    protected abstract int getNormalWidth();

    protected abstract int getSpecialWidth();

    protected abstract String getScoreTitle();

    final String getAccumulatedScores( List<Frame> frames ) {
        String toPrint = getScoreTitle() + DIVIDER;
        int accumulator = 0;
        for (int i = 0; i < frames.size() ; i++) {
            Frame currentFrame = frames.get( i );
            accumulator += currentFrame.calculateScore();
            toPrint += i == LAST_FRAME ? padScore( accumulator, getSpecialWidth() ) : padScore( accumulator, getNormalWidth() );
        }
        return toPrint;
    }

    final String padScore( int score, int availableSpacing ) {
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
