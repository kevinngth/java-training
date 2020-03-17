package com.foobarqix.foobarqix;

import java.util.HashMap;

public class FooBarQix {

    HashMap<Integer, String> map = new HashMap();

    FooBarQix() {
        map.put( 3, "Foo");
        map.put( 5, "Bar");
        map.put( 7, "Qix");
    }

    public String print( Integer i ) {
        String result = "";
        result += divisible(i);
        result += contains(i);
        if ( result.equals( "" ) ) {
            result += i.toString();
        }
        return result;
    }

    private String divisible(Integer i) {
        String result = "";
        for (Integer j : this.map.keySet()) {
            if (i % j == 0) {
                result += this.map.get(j);
            }
        }
        return result;
    }

    private String contains(Integer i) {
        String result = "";
        for ( String num : i.toString().split("") ) {
            for (Integer j : this.map.keySet()) {
                if ( num.contains(j.toString()) ) {
                    result += this.map.get(j);
                }
            }
        }
        return result;
    }
}
