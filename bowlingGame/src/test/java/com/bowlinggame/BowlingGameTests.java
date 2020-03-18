package com.bowlinggame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTests {

	@Test
	void shouldReturn4() {
		BowlingGame bowlingGame = new BowlingGame();
		assertThat( bowlingGame.getScore ).isEqualTo(  );
	}
}
