package com.mongodb.starter.practice;

/*  
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

This is useful in handling the addition of big integers above 2^31. 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.       
*/


    public class AddStrings {

        public String addStrings(String num1, String num2) {
            String result = "";
            String actualResult = "";
            String add = "";
            int carry = 0;
            int length = num1.length()-num2.length();
        
            if (length > 0){
                for(int i = 0; i < length; i++){
                    add += "0";
                }
                num2 = add + num2;
            }

            if (length < 0){
                for(int i = 0; i < length; i++){
                    add += "0";
                }
                num1 = add + num1;
            }

            for (int i = num1.length()-1; i >=0; i--){
                char mockNum1 = num1.charAt(i);
                char mockNum2 = num2.charAt(i);

                int currentNum1 = mockNum1 - '0';
                int currentNum2 = mockNum2 - '0';
                int currentResult = currentNum1 + currentNum2 + carry;

                carry = 0;

                String stringSum = String.valueOf(currentResult);

                if (currentResult > 10){
                    result += stringSum.charAt(1);
                    carry = stringSum.charAt(0) - '0';
                } else {
                    result += stringSum.charAt(0);
                }
            }

            for(int i = result.length() - 1; i >= 0; i--){
                actualResult += result.charAt(i);
            }
            return actualResult;

        }

        public static void main(String[] args){
            String num1 = "19";
            String num2 = "23";
            System.out.println(num1 + " + " + num2 + " = " + new AddStrings().addStrings(num1, num2));
        }
    }
