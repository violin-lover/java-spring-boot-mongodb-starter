package com.mongodb.starter.practice;

public interface PrimePair {
    int getLesser();

    int getGreater();
    
    /**
     * Output the contents as
     * (1, 5)
     * @return
     */
    String toString();
}