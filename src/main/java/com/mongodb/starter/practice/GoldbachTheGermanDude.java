package com.mongodb.starter.practice;
import java.util.ArrayList;
import java.util.List;

public class GoldbachTheGermanDude implements PrimePair{
    private int lesser = 1;
    private int greater = 3;

    public GoldbachTheGermanDude(int less, int great) {
        this.lesser = less;
        this.greater = great;
    }

    @Override
    public int getLesser() {
        return lesser;
    }

    @Override
    public int getGreater() {
        return greater;
    }

    @Override
    public String toString() {
        return ("(" + lesser + ", " + greater + ")");
    }

    public static void main(String[] args){
        //declaring what to output
        //you cannot "new" an interface, only a class
        PrimePair primep = new GoldbachTheGermanDude(3,5);
        PrimePair primep2 = new GoldbachTheGermanDude(2, 81);
        List<PrimePair> listPrimeP = new ArrayList<PrimePair>();

        //printing out all methods
        System.out.println(primep.getLesser());
        System.out.println(primep.getGreater());
        System.out.println(primep.toString());

        //add prime pairs into the arraylist and output
        listPrimeP.add(primep);
        listPrimeP.add(primep2);
        System.out.println(listPrimeP);
    }
    
}
