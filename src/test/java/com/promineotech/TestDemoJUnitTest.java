package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Unit tests for the {@code TestDemo} class. This class tests the functionality
 * of the {@code addPositive} method, ensuring it correctly adds two positive
 * numbers and throws an exception when given invalid inputs.
 */
class TestDemoJUnitTest {

	private TestDemo testDemo;

	/**
	 * Sets up a new instance of {@code TestDemo} before each test execution.
	 *
	 * @throws Exception if any setup error occurs
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/**
	 * Parameterized test that verifies the {@code addPositive} method correctly
	 * adds two positive numbers or throws an exception if either parameter is zero
	 * or negative.
	 * 
	 * @param a               First integer input
	 * @param b               Second integer input
	 * @param expected        Expected sum if both numbers are positive
	 * @param expectException Boolean indicating whether an exception is expected
	 */
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		System.out.println(a + ", " + b + ", " + expected + ", expectException: " + expectException);

	}

	/**
	 * Provides test arguments for the parameterized test
	 * {@code assertThatTwoPositiveNumbersAreAddedCorrectly}.
	 * 
	 * @return A {@code Stream} of {@code Arguments} representing valid and invalid
	 *         test cases.
	 */
	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
			arguments(2, 4, 6, false), // Valid case: 2 + 4 = 6
			arguments(10, 15, 25, false), // Valid case: 10 + 15 = 25
			arguments(1, 1, 2, false), // Valid case: 1 + 1 = 2
			arguments(-1, 5, 0, true), // Invalid case: -1 (exception expected)
			arguments(3, 0, 0, true), // Invalid case: 0 (exception expected)
			arguments(-2, -3, 0, true), // Invalid case: both negative (exception expected)
			arguments(7, -1, 0, true) // Invalid case: one negative (exception expected)
		);
		// @formatter:on
	}

	/**
	 * New JUnit Test 1, created before I saw the Mockito test so I created New
	 * JUnit Test 2. Tests the squareNumber method to ensure it returns the correct
	 * squared value.
	 */
	@Test
	void assertThatNumberIsSquaredCorrectly() {
		// @formatter:off
		assertThat(testDemo.squareNumber(2)).isEqualTo(4);
		assertThat(testDemo.squareNumber(3)).isEqualTo(9);
		assertThat(testDemo.squareNumber(5)).isEqualTo(25);
		assertThat(testDemo.squareNumber(10)).isEqualTo(100); 
		assertThat(testDemo.squareNumber(1001)).isEqualTo(1002001); // Handling a large number
		assertThat(testDemo.squareNumber(-4)).isEqualTo(16);        // Squaring negative number gives positive result
	}
	// @formatter:on

	/*
	 * In the real world there would usually be no need to exclude zero
	 * from a squaring function. I include it purely for demo purposes.
	 */
	@Test
	void assertThatNegativeNumberThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testDemo.squareNumber(0);
		});

		assertThat(exception.getMessage()).isEqualTo("Number cannot be zero!");
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		// Create a spy of the TestDemo instance
		TestDemo mockDemo = spy(new TestDemo());

		// Mock the getRandomInt method to return 5
		doReturn(5).when(mockDemo).getRandomInt();

		// Call the randomNumberSquared method
		int result = mockDemo.randomNumberSquared();

		// Assert that the result is 25 (since 5 squared is 25)
		assertThat(result).isEqualTo(25);
		System.out.println("Result is " + result);
	}

	/**
	 * New JUnit Test 2 Unit test for the findMax method.
	 */
	@Test
	void assertThatFindMaxWorksCorrectly() {
		assertThat(testDemo.findMax(10, 5)).isEqualTo(10);
		assertThat(testDemo.findMax(-1, -5)).isEqualTo(-1);
		assertThat(testDemo.findMax(7, 7)).isEqualTo(7);
		assertThat(testDemo.findMax(0, 100)).isEqualTo(100);
	}

}