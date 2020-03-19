package com.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTests {

	@Test
	void shouldReturn0() {
		BowlingGame bowlingGame = new BowlingGame();
		assertThat( bowlingGame.getScore() ).isEqualTo( 0 );
	}

	@Test
	void shouldReturnScore() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll( new Frame( 0, 2 ) );
		assertThat( bowlingGame.getScore() ).isEqualTo( 2 );
	}

	@Test
	void shouldReturnNormalCalculation() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(new Frame(0, 0 ), new Frame( 2,7 ) );
		assertThat( bowlingGame.getScore() ).isEqualTo( 9 );
	}

	@Test
	void shouldCalculateBonusFromSpare() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll( new Frame( 0, 0 ), new Frame( 2, 8 ), new Frame( 8, 1 ) );
		assertThat( bowlingGame.getScore() ).isEqualTo( 27 );
	}

	@Test
	void shouldCalculateBonusFromStrike() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll( new Frame( 10, 0 ), new Frame( 2, 7 ) );
		assertThat( bowlingGame.getScore() ).isEqualTo( 28 );
	}

	@Test
	void shouldGetExtraRoll() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll( new Frame( 0, 0 ), new Frame( 2, 8 ), new Frame( 8, 0 ), new Frame( 10, 0 ), new Frame( 10, 0 ), new Frame( 10, 0 ), new Frame( 2, 8 ), new Frame( 5, 2 ), new Frame( 4, 2 )/*, new Frame( 2, 8, 2 ) */);
		assertThat( bowlingGame.getScore() ).isEqualTo( 126 );
	}
}
