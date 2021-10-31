package com.mongodb.starter.practice;

import java.util.ArrayList;
import java.util.List;

public class mathPythagTriple implements PythagTripFinder{

    @Override
    public List<PythagTriple> getTriples(int cLimit) {
        List<PythagTriple> allPythagTriples = new ArrayList<PythagTriple>();
        if(cLimit % 2 == 0){
            cLimit = cLimit-1;
        }

        int possibleA = 0;
        int possibleB = 0;

        for(int i = 3; i < cLimit; i++){
            possibleB = cLimit-1;
            possibleA = (cLimit*cLimit)-(possibleB*possibleB);

            if((possibleA*possibleA)+(possibleB*possibleB)==(cLimit*cLimit)){
                PythagTriple pythagoreanTriple = new findPythagTriple(possibleA, possibleB, cLimit);
                allPythagTriples.add(pythagoreanTriple);
            }
        }

        return allPythagTriples;
    }

    public static void main(String[] args){
        PythagTripFinder pythagoreanTriples = new mathPythagTriple();
        System.out.println(pythagoreanTriples.getTriples(10));
    }
    
}
