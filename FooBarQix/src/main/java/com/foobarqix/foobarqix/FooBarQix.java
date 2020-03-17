package com.foobarqix.foobarqix;

public class FooBarQix {


    public String print( Integer i ) {
        String result = "";
        if ( i % 3 == 0 ) {
            result += "Foo";
        }
        if ( i % 5 == 0 ) {
            result += "Bar";
        }
        if ( i % 7 == 0 ) {
            result += "Qix";
        }
        for ( String num : i.toString().split("") ) {
            if ( num.contains("3") ) {
                result += "Foo";
            } else if ( num.contains("5") ) {
                result += "Bar";
            } else if ( num.contains("7") ) {
                result += "Qix";
            }
        }
        if ( result == "") {
            result += i.toString();
        }
        return result;
    }
}
