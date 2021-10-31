package com.mongodb.starter.practice;

public class RomanNumerals {
    public static int romanNumeralToNum(String numeral){
        int value = 0;

        for(int i = numeral.length()-1; i >= 0; i--){

            if(numeral.charAt(i) == 'I'){
                value += (value >= 5 ? -1 : 1);
            }
            
            if(numeral.charAt(i) == 'V'){
                value += 5;
            }

            if(numeral.charAt(i) == 'X'){
                value += (value >= 50 ? -10 : 10);
            }
            
            if(numeral.charAt(i) == 'L'){
                value += 50;
            }

            if(numeral.charAt(i) == 'C'){
                value += (value >= 500 ? -100 : 100);
            }

            if(numeral.charAt(i) == 'D'){
                value += 500;
            }

            if(numeral.charAt(i) == 'M'){
                value += 1000;
            }
        }
        return value;
    }

    public static void main(String[] args){
        String numeralToConvert = "CMIV";
        System.out.println(romanNumeralToNum(numeralToConvert));
    }
}
