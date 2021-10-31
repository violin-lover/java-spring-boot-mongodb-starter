package com.mongodb.starter.practice;

public class MaxProfit {

    public static int profitMax(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length-1; i++){
            for(int k = i+1; k < prices.length; k++){
                if((prices[k] - prices[i]) > maxProfit){
                    maxProfit = prices[k] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {1,2,3,4,5,6,7};
        System.out.println(profitMax(prices));
    }
}
