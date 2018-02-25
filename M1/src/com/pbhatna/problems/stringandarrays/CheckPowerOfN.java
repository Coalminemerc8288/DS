package com.pbhatna.problems.stringandarrays;

/**
 * Given an integer, write a function to determine if it is a power of n
 * Test if number is perfectly divisible by n then it is power of n else not
 */
public class CheckPowerOfN {
    public static boolean isPow(double value, int n) {
        if (value < 0) {
            return false;
        }

        while (value % n == 0) {
            value  = value/n;
            System.out.println(value);
        }

        return value == 1;
    }

    public static double pow(double value, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1/ pow(value, -n);
        }

        double result = pow(value, n/2);
        if (result % 2 == 0) {
            return result * result;
        } else {
            return value * result * result;
        }
    }

    public static void main (String[] args) {
        System.out.println("-1->"+isPow(9, 3));
        System.out.println("-2->"+pow(3, 3));
    }
}
