package com.mongodb.starter.practice;

import java.util.ArrayList;
import java.util.List;

public class GoldbachTheGermanDude2 implements GoldbachService{

    @Override
    public List<PrimePair> findPrimePairs(int even) throws IllegalArgumentException {
        List<PrimePair> primes = new ArrayList<PrimePair>();
        if(even % 2 != 0){
            throw new IllegalArgumentException("not an even integer. albedo sad. déprimé. :(");
        }

        long startTime = System.nanoTime();
        for(int i = 2; i <= even/2; i++){
            boolean first = isPrime(i);
            boolean last = isPrime(even - i);

            if(first && last){
                PrimePair yesPrimePair = new GoldbachTheGermanDude(i, (even-i));
                primes.add(yesPrimePair); 
            }
        }
        long timeTaken = System.nanoTime()-startTime;
        System.out.println("Time Taken to check Prime: " + even + "=+" + timeTaken/1000000 + " miliseconds");
        return primes;
    }
    
    private boolean isPrime(int num) {
        int count = factorCount(num);
        if(count == 1){
            return true;
        } 
        return false;   
    } 

    private int factorCount(int num) {
        int count = 0;
        for (int i = 2; i <= num; ++i) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        GoldbachService declareStuff = new GoldbachTheGermanDude2();
        System.out.println(declareStuff.findPrimePairs(1000000));
    }
}
