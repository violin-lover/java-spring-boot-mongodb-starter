package com.mongodb.starter.practice;

public class findPythagTriple implements PythagTriple{
    private int a = 3;
    private int b = 4;
    private int c = 5;

    public findPythagTriple(int a1, int b1, int c1){
        this.a = a1;
        this.b = b1;
        this.c = c1;
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getC() {
        return c;
    }

    @Override
    public String toString(){
        return ("(" + a + ", " + b + ", " + c + ")");
    }

    public static void main(String[] args){
        PythagTriple pythagorean = new findPythagTriple(3,4,5);
        System.out.println(pythagorean.toString());
    }
    
}
