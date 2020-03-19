package com.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	List<Frame> frames = new ArrayList<Frame>();
	private int score = 0;
	public int getScore() {
		for (int i = 0; i < frames.size(); i++) {
			Frame currentFrame = frames.get( i );
			if ( currentFrame.isStrike() ) {
				if ( frames.get( i + 1 ).getFirstRoll() == 10 ) {
					currentFrame.setFrameScore( currentFrame.getTotal() + frames.get( i + 1 ).getFirstRoll() + frames.get( i + 2 ).getFirstRoll() );
				} else {
					currentFrame.setFrameScore( currentFrame.getTotal() + frames.get( i + 1 ).getTotal() );
				}
			} else if ( currentFrame.isSpare() ) {
				currentFrame.setFrameScore( currentFrame.getTotal() + frames.get( i + 1 ).getFirstRoll() );
			} else {
				currentFrame.setFrameScore( currentFrame.getTotal() );
			}
		}
		for ( Frame frame : frames ) {
			score += frame.getFrameScore();
		}
		return score;
	}
	public void roll(Frame... rolls) {
		for (Frame roll : rolls) {
			frames.add( roll );
		}
	}
}
