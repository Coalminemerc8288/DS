package com.pbhatna.problems.stringandarrays;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * Test if number is perfectly divisible by 2 then it is power of 2 else not
 */
public class CheckPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
            System.out.println(n);
        }
        return n == 1;
    }
    public static void main (String [] args) {
        System.out.println(isPowerOfTwo(256));
    }
}
