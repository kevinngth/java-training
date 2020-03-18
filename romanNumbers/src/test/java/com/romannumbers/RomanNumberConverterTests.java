package com.romannumbers;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RomanNumberConverterTests {

	@Test
	void shouldReturnI() {
		RomanNumberConverter romanNumberConverter = new RomanNumberConverter();
		assertThat( romanNumberConverter.convert( 1 ) ).isEqualTo( "I" );
	}

	@Test
	void shouldReturnVI() {
		RomanNumberConverter romanNumberConverter = new RomanNumberConverter();
		assertThat( romanNumberConverter.convert( 6 ) ).isEqualTo( "VI" );
	}
//		22 => XXII
//		40 => XL
//		99 => XCIX
//
//		IV => 4
//		II => 2
//		LVI => 56
}