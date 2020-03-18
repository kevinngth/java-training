package com.romannumbers;

import java.util.ArrayList;
import java.util.List;

public class ArabicToRomanConverter {
	private List <RomanArabicMap> list = new ArrayList<>();
	protected ArabicToRomanConverter() {
		list.add(new RomanArabicMap(100,"C"));
		list.add(new RomanArabicMap(90,"XC"));
		list.add(new RomanArabicMap(50,"L"));
		list.add(new RomanArabicMap(40,"XL"));
		list.add(new RomanArabicMap(10,"X"));
		list.add(new RomanArabicMap(9,"IX"));
		list.add(new RomanArabicMap(5,"V"));
		list.add(new RomanArabicMap(4,"IV"));
		list.add(new RomanArabicMap(1,"I"));
	}

	protected String convert(int input ) {
		String result = "";
		Integer balance = input;
		while ( balance > 0 ) {
			for( RomanArabicMap item : list ) {
				if ( balance >= item.getArabicValue() ) {
					balance -= item.getArabicValue();
					result += item.getRomanValue();
					break;
				}
			}
		}
		return result;
	}
}

