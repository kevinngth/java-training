package com.romannumbers;

public class RomanNumberConverter {

	String convert( int input ) {
		if ( input == 1 ) {
			return "I";
		} else if ( input == 6 ) {
			return "VI";
		} else {
			return "";
		}
	}
}

