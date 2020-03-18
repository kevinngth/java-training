package com.romannumbers;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RomanToArabicConverterTests {

    @Test
    void shouldReturn4() {
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        assertThat( romanToArabicConverter.convert( "IV" ) ).isEqualTo( 4 );
    }
//

    @Test
    void shouldReturn2() {
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        assertThat( romanToArabicConverter.convert( "II" ) ).isEqualTo( 2 );
    }

    @Test
    void shouldReturn56() {
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        assertThat( romanToArabicConverter.convert( "LVI" ) ).isEqualTo( 56 );
    }
}