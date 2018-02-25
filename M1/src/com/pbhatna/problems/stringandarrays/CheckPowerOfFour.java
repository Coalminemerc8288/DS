package com.pbhatna.problems.stringandarrays;

/**
 * Given an integer, write a function to determine if it is a power of 4.
 * Test if number is perfectly divisible by 4 then it is power of two else not
 */
public class CheckPowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n < 0) {
            return false;
        }

        while (n % 4 == 0) {
            n  = n/4;
            System.out.println(n);
        }

        return n == 1;
    }

    public static void main (String[] args) {
        System.out.println("-->"+isPowerOfFour(4096));
    }
}
