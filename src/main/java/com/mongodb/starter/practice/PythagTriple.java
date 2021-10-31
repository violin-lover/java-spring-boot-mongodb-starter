package com.mongodb.starter.practice;

/**
 * https://en.wikipedia.org/wiki/Pythagorean_triple
 * 
 * A^2 + B^2 = C^2 
 * A < B < C 
 * A, B and C have no common factors, or GCD(A, B, C) = 1.
 */
public interface PythagTriple {
    
    int getA();

    int getB();

    int getC();

    /**
     * 
     * @return The string representation in the form (3, 4, 5) for (A, B, C)
     */
    String toString();
}

