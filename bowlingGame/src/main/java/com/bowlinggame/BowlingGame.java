package com.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	List<Frame> frames = new ArrayList<Frame>();
	public int getScore() {
		int score = 0;
		for (int i = 0; i < frames.size(); i++) {
			Frame previousFrame = i > 0 ? frames.get( i - 1 ) : null;
			Frame currentFrame = frames.get( i );
			if ( i > 0 && previousFrame.isSpare() ) {
				score += currentFrame.getFirstRoll();
			} else if ( i > 0 && previousFrame.isStrike() ) {
				score += currentFrame.getTotal();
			} else if ( i == 9 ) {
				score += currentFrame.tenthFrameBonusScore();
			}
			score += currentFrame.getTotal();
		}
		return score;
	}
	public void roll(Frame... rolls) {
		for (Frame roll : rolls) {
			frames.add( roll );
		}
	}
}
