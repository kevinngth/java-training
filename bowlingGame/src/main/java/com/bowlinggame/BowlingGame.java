package com.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	List<Frame> frames = new ArrayList<Frame>();

	private int score = 0;

	public int getScore() {
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
