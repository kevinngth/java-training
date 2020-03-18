package com.primefactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

public class PrimeFactorGenerator {

	public Integer[] generate(int input) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Integer balance = input;
		while( balance > 1 ) {
			for (int testNum = 2; testNum <= balance; testNum++) {
				if ( balance % testNum == 0 ) {
					balance /= testNum;
					primes.add( testNum );
					break;
				}
			}
		}
		return primes.stream().toArray(Integer[]::new);
	}
}