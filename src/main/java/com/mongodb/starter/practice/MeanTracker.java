package com.mongodb.starter.practice;

class  MeanTracker  {
    /** initialize your data structure here. */

    int sum = 0;
    int length = 0;
    double mean; 
    
    public MeanTracker() {
        mean = 0.0;
    }
   
    public void addNum(int num) {
       sum += num;
       length++;
    }
   
    public double findMean() {
        return (double)sum/length;
    }

    public static void main(String[] args){
        MeanTracker obj = new MeanTracker();

        //the added numbers
        obj.addNum(1);
        obj.addNum(2);

        //the thingy to find the mean
        double meany = obj.findMean();
        System.out.println("The mean of the numbers is: " + meany);

        //more added number
        obj.addNum(3);

        //updated mean
        meany = obj.findMean();
        System.out.println("The mean of the numbers is: " + meany);
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 *  MeanTracker obj = new MeanTracker();
 * obj.addNum(num);
 * double meany = obj.findMean();
 */
