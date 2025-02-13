package com.promineotech.td;

import java.util.Iterator;
import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	/**
	 * Adds two positive integers and returns their sum. Throws an
	 * IllegalArgumentException if either parameter is zero or negative.
	 * 
	 * @param a First integer
	 * @param b Second integer
	 * @return The sum of a and b
	 * @throws IllegalArgumentException if a or b is zero or negative
	 */
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} // else {System.out.println(a + ", " + b );}
			// int result = a + b;
		System.out.print("Numbers to be added: " + a +"," + b + '\n');

		return a + b;
	}

	/**
	 * New JUnit Test 1, created before I saw the Mockito test
	 * so I created New JUnit Test 2.
	 * Computes the square of a given non-negative integer. Throws an
	 * IllegalArgumentException if the input is negative.
	 * 
	 * @param number The integer to be squared
	 * @return The squared value of the input number
	 * @throws IllegalArgumentException if the number is negative
	 */
	public int squareNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be non-negative!");
		}
		
		System.out.print("Number to be squared: " + number + '\n');
		return number * number;
	}

	/**
	 * Generates a random integer between 1 and 10 (inclusive) and returns its
	 * square.
	 *
	 * @return the square of a randomly generated integer between 1 and 10
	 */
	public int randomNumberSquared() {
		int result = getRandomInt();
		
		System.out.print("Random number: " + result + '\n');
		return result * result;
	}

	/**
	 * Generates a random integer between 1 and 10 (inclusive). This method has
	 * package-private visibility.
	 *
	 * @return a random integer between 1 and 10
	 */
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	/**
	 * New JUnit Test 2
	 * Method to find the maximum of two integers.
	 * 
	 * @param a First integer.
	 * @param b Second integer.
	 * @return The greater of the two integers.
	 */
	public int findMax(int a, int b) {
		return (a > b) ? a : b;
	}

}
