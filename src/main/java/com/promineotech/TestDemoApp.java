package com.promineotech;

// Main application class for demonstrating TestDemo methods
public class TestDemoApp {

    public static void main(String[] args) {
        // Create an instance of TestDemo
        TestDemo demo = new TestDemo();
        
        // Call addPositive() method with two positive integers and display the result
        int sum = demo.addPositive(5, 10);
        System.out.println("Sum: " + sum);  // Expected output: 15
        
        // Call squareNumber() method with an integer and display the squared value
        int squared = demo.squareNumber(4);
        System.out.println("Squared: " + squared);  // Expected output: 16
        
        // Call randomNumberSquared() method and display the squared random number
        int randomSquared = demo.randomNumberSquared();
        System.out.println("Random Squared: " + randomSquared);  
        // Output varies as it is based on a random number
        
        // Call findMax() method with two integers and display the maximum
        int max = demo.findMax(6, 2);
        System.out.println("Max: " + max);  // Expected output: 6
    }
}
