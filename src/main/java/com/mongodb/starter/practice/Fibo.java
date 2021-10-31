package com.mongodb.starter.practice;

/**
 * 
 * The first number in the Fibonacci sequence is 0. The second is 1. --
 * https://en.wikipedia.org/wiki/Fibonacci_number
 * 
 * We are curious in further features of the sequence.
 * 
 * Create a class to implement the methods to address the curiosity.
 */

interface Fibo {

    /**
     * Calculate how many Fibonacci numbers are in the range [0, Integer.MAX_VALUE]
     * --https://www.educative.io/edpresso/what-is-integermaxvalue
     */

    int fibCount();

    /**
     * What is the largest Fibonacci number in the range?
     */

    int maxFib();

    /**
     * Among the Fibonacci number in the range, find the numbers that are perfect
     * squares.
     */
    int[] squareFibs();

    /**
     * Among the Fibonacci number in the range, find the prime numbers
     * https://en.wikipedia.org/wiki/Fibonacci_prime
     * https://www.geeksforgeeks.org/prime-numbers/
     */

    int[] primeFibs();

    /**
     * For each Fibanacci number in the sequence, calculate its digit sum (13--> 4,
     * 55 --> 10), and generate the sequence of those sums
     * http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibmaths.html#section1.2
     */

    int[] digitSum();
}


