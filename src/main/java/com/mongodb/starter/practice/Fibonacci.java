package com.mongodb.starter.practice;

import java.util.ArrayList;

public class Fibonacci implements Fibo{
    ArrayList<Integer> fibos = new ArrayList<Integer>();
    ArrayList<Integer> squareFibos = new ArrayList<Integer>();
    Fibonacci(){
        fibos.add(0);
        fibos.add(1);
    }


    @Override
    public int fibCount() {
        int amountOfFiboNums = 2;
        int integerMaxValue = Integer.MAX_VALUE;

        for(int i = 2; i < 50; i++){
            int currentFiboNum = fibos.get(i-1) + fibos.get(i-2);

                if(fibos.get(i-1) >= 1000050000 && fibos.get(i-2) >= 1000050000 && currentFiboNum < integerMaxValue){
                    return amountOfFiboNums;
                } else {
                    fibos.add(currentFiboNum);
                    amountOfFiboNums++;
                }

                //if(){}
        }
        return amountOfFiboNums;
    } 

    @Override
    public int maxFib() {
        int maxFiboNum = 0;
        for(int i = 2; i < 47; i++){
            int currentFiboNum = fibos.get(i-1) + fibos.get(i-2);
            fibos.add(currentFiboNum);

            maxFiboNum = currentFiboNum;
        }
        System.out.println(fibos);
        return maxFiboNum;
    }

    @Override
    public int[] squareFibs() {
        
        for(int i = 1; i < fibos.size(); i++){
            if(Math.floor(Math.sqrt(fibos.get(i))) == Math.ceil(Math.sqrt(fibos.get(i)))){
                squareFibos.add(fibos.get(i));
            }
        }
        int[] squaresArray = squareFibos.stream().mapToInt(i->i).toArray();
        return squaresArray;
    }

    @Override
    public int[] primeFibs() {
        return null;
    }

    @Override
    public int[] digitSum() {
        return null;
    }

    public static void main(String[] args){
        System.out.println("The max amount of Fibonacci numbers from 0 to Integer.MAX_VALUE is: " + new Fibonacci().fibCount());
        System.out.println("The greatest Fibonacci number up to Integer.MAX_VALUE is: " + new Fibonacci().maxFib());
        System.out.println("Fibonacci numbers that are also squares up to Integer.MAX_VALUE are: " + new Fibonacci().squareFibs());
        //System.out.println(new Fibonacci().maxFib());
    }

}
