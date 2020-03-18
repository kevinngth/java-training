package com.romannumbers;

public class RomanNumberConverter {

	String convert( int input ) {
		String result = "";
		Integer balance = input;
		while ( balance > 0 ) {
			if ( balance > 5 ) {
				balance -= 5;
				result = "V" + result;
			} else {
				balance -= 1;
				result += "I";
			}
		}
		return result;
	}
}

