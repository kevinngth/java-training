package com.bowlinggame;

import java.util.List;

public abstract class Formatter {

    static final String DIVIDER = " | ";
    static final String NEW_LINE = "\n";
    static final String SPACE = " ";
    static final int LAST_FRAME = 9;

    public String toString( List<Frame> frames ) {
        String result = frames.isEmpty() ? getTemplate() : getTemplate() + getFrameScores( frames ) + getAccumulatedScores( frames );
        System.out.println( result );
        return result;
    }

// HEADER SECTION

    abstract String getTemplate();

// FRAME SCORES SECTION

    abstract String getFrameScores( List<Frame> frames );

// ACCUMULATED SCORE SECTION

    abstract String getAccumulatedScores( List<Frame> frames );

    String padScore( int score, int availableSpacing ) {
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
