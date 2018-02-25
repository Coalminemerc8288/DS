package com.pbhatna.problems.stringandarrays;

/**
 * Given an integer, write a function to determine if it is a power of 3.
 * Test if number is perfectly divisible by 3 then it is power of 3 else not
 */
public class CheckPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if (n < 0) {
            return false;
        }

        while (n % 3 == 0) {
            n = n/3;
            System.out.println(n);
        }
        return n == 1;
    }

    public static void main (String[] args) {
        System.out.println("-->"+isPowerOfThree(81));
    }
}
