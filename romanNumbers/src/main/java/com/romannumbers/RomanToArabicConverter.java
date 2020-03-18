package com.romannumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class RomanToArabicConverter {
    private HashMap<String, Integer> conversionMap = new HashMap();
    public RomanToArabicConverter() {
        conversionMap.put( "C", 100 );
        conversionMap.put( "L", 50 );
        conversionMap.put( "X", 10 );
        conversionMap.put( "V", 5 );
        conversionMap.put( "I", 1 );
    }

    Integer convert(String input) {
        String[] arrayOfLetters = input.split("");
        int[] arrayOfNumbers = new int[arrayOfLetters.length];
        for (int i = 0; i < arrayOfLetters.length; i++) {
            arrayOfNumbers[arrayOfLetters.length -1 - i] = conversionMap.get(arrayOfLetters[i]);
        }
        Integer result = 0;
        for ( int num : arrayOfNumbers ) {
            if ( num < result ) {
                result -= num;
            } else {
                result += num;
            }
        }
        return result;
    }
}
