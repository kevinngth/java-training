package com.primefactor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PrimeFactorGeneratorTests {
	@Test
	void shouldReturnEmpty() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 1 ) ).isEmpty();
	}

	@Test
	void shouldReturn2() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 2 ) ).containsExactly( 2 );
	}

	@Test
	void shouldReturn3() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 3 )).containsExactly( 3 );
	}

	@Test
	void shouldReturn2and2() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 4 )).containsExactlyInAnyOrder( 2, 2 );
	}

	@Test
	void shouldReturn5() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 5 )).containsExactly( 5 );
	}

	@Test
	void shouldReturn2and3() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 6 )).containsExactlyInAnyOrder( 2, 3 );
	}

	@Test
	void shouldReturn() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 7 )).containsExactly( 7 );
	}

	@Test
	void shouldReturnThree2s() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 8 )).containsExactlyInAnyOrder( 2, 2, 2 );
	}

	@Test
	void shouldReturnTwo3s() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 9 )).containsExactlyInAnyOrder( 3, 3 );
	}

	@Test
	void  shouldReturnAllPrimes() {
		PrimeFactorGenerator primeFactor = new PrimeFactorGenerator();
		assertThat( primeFactor.generate( 4620 )).containsExactlyInAnyOrder( 2, 2, 3, 5, 7, 11 );
	}
}
