package com.romannumbers;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArabicToRomanConverterTests {

	@Test
	void shouldReturnI() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 1 ) ).isEqualTo( "I" );
	}

	@Test
	void shouldReturnVI() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 6 ) ).isEqualTo( "VI" );
	}

	@Test
	void shouldReturnXXII() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 22 ) ).isEqualTo( "XXII" );
	}

	@Test
	void shouldReturnIV() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 4 ) ).isEqualTo( "IV" );
	}

	@Test
	void shouldReturnXL() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 40 ) ).isEqualTo( "XL" );
	}

	@Test
	void shouldReturnXCIX() {
		ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
		assertThat( arabicToRomanConverter.convert( 99 ) ).isEqualTo( "XCIX" );
	}


//		IV => 4
//		II => 2
//		LVI => 56
}