package com.mongodb.starter.practice;

class SimpleMath {
    public int sqrt(int num) {
        for (int i = 1; i < num; i++) {
            if (i * i > num) {
                // the difference between i-- and --i is what is done first, the subtraction, or
                // the return of the number i
                return --i;
            }
        }
        return 0;
    }

    public int sqrt2(int num) {
        for (int lower = 1, middle = 2, higher = num; lower == higher;) {
            middle = (lower + higher) / 2;

            if (middle * middle == num || (middle * middle < num && (middle + 1) * (middle + 1) > num)) {
                return middle;
            }

            if ((middle + 1) * (middle + 1) < num) {
                lower = --middle;
            }

            if ((middle - 1) * (middle - 1) > num) {
                higher = middle;
            }
        }
        return 0;
    }

    public int sqrt3(int num) {
        return issqrtR(num, 1, num);
    }

    private int issqrtR(int num, int lower, int higher) {
        int middle = (lower + higher) / 2;
        if (middle * middle == num || (middle * middle < num && (middle + 1) * (middle + 1) > 1)) {
            return middle;
        }

        if ((middle) * (middle) < num) {
            return issqrtR(num, ++middle, higher);
        } else {
            return issqrtR(num, lower, --middle);
        }
    }

    public int sqrt4(int num) {
        if (num < 4) {
            return 1;
        }

        int square = 2 * sqrt4(num / 4);
        if ((square + 1) * (square + 1) <= num) {
            square++;
        }
        return square;
    }

    long sqrt5(int num) {
        // https://www.geeksforgeeks.org/square-root-of-a-perfect-square/
        // babylonian
        int x = num;
        int y = 1;
        while (x > y) {
            x = (x + y) / 2;
            y = num / x;
        }
        return (long) x;
    }

    //-------

    public int sqrtBabR(int x) {
        if (x < 4)
            return 1;
        return sqrtBabRhelp(x, x / 2);
    }

    private int sqrtBabRhelp(int x, int guess) {
        if (guess * guess == x || ((guess + 1) * (guess + 1) > x && guess * guess < x)) {
            return guess;
        } else
            return sqrtBabRhelp(x, (guess + x / guess) / 2);
    }

    //-------


    public int sqrtBakshali(double num) {
        double guess = num / 2;

        for (double difference = 0, ratio = 0,
                sum = 0; Math.abs(guess * guess - num) > 0.1; guess = sum - ((ratio * ratio) / (2 * sum))) {
            difference = num - (guess * guess);
            ratio = difference / (2 * guess);
            sum = guess + ratio;

            /*
             * difference = num - (guess*guess); ratio = difference / 2 / guess; sum = guess
             * + ratio; guess = sum- (ratio*ratio) / 2 / sum;
             */
        }
        return (int) guess; // don't need math.round cause int does that for you
    }

    //--------

    public int sqrtBakshaliRecursive(int num) {
        if (num < 4)
            return 1;
        return sqrtBabRhelp(num, num / 2);
    }

    private int sqrtBabRecursiveHelp(int num, int guess) {
        if (guess * guess == x || ((guess + 1) * (guess + 1) > x && guess * guess < x)) {
            return guess;
        } else
            return sqrtBabRhelp(x, (guess + num / guess) / 2);
    }

    /*
     * public int sqrtBakh(int s) { if (s < 0) throw new
     * IllegalArgumentException("The square must be positive."); double guess = s /
     * 2; for (double diff = 0, ratio = 0, sum = 0; Math.abs(guess * guess - s) >
     * 0.1; System.out .println("Guess: " + guess)) { diff = s - guess * guess;
     * ratio = diff / 2 / guess; sum = guess + ratio; guess = sum - ratio * ratio /
     * 2 / sum; } return (int) guess; }
     */

    public static void main(String[] args) {
        SimpleMath number = new SimpleMath();
        System.out.println(number.sqrt(10));
        System.out.println(number.sqrt5(122));
        System.out.println(number.sqrtBakshali(17));
        // System.out.println(sq.sqrtBabyl(100));
    }
}
