package com.romannumbers;

public class RomanArabicMap {
    private int arabicValue;
    private String romanValue;

    public RomanArabicMap( int arabicValue, String romanValue ) {
        this.arabicValue = arabicValue;
        this.romanValue = romanValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public String getRomanValue() {
        return romanValue;
    }
}
