package com.mongodb.starter.practice;

import java.util.List;

public interface GoldbachService {
    // Given an even number, find a pair of prime numbers that 
    // that add up to the even number.
    // The other prime is obviously (even - output)
    // test cases: 12345678, 20000000, 3000, 400, 50, 6
    // Your code will be called as:
    // GoldbachService gb = new YourClassName();
    // List<PrimePair> prms= gb.findPrimePairs(400);
    // System.out.println(prms);
    // System.out.println(prms.getLesser());

    /**
     * 
     * @param even, an even number >0
     * @return All pairs of prime numbers that sum to the even input
     * @throws IllegalArgumentException Rejects the input if it is not even.
     */
    List<PrimePair> findPrimePairs(int even) throws IllegalArgumentException;
}
