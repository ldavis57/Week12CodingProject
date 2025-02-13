package com.promineotech;

public class TestDemoApp {

	public static void main(String[] args) {
		TestDemo demo = new TestDemo();
        int sum = demo.addPositive(5, 10);
        System.out.println("Sum: " + sum);
        
        int squared = demo.squareNumber(4);
        System.out.println("Squared: " + squared);
        
        int randomSquared = demo.randomNumberSquared();
        System.out.println("Random Squared: " + randomSquared);
        
        int max = demo.findMax(6,2);
        System.out.println("Max: " + max);
	}
}
