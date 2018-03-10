package com.pbhatna.problems.advanced.recursion;

/**
 * Factorial in a recursive manner
 *  N! = N * N-1 * N-2....1
 *  4! = 4 * 3 * 2 * 1
 */
public class Factorial {

    /**
     * Factorial with regular recursion way
     */
    public static int factorial(int n) {
        if (n == 1) {return 1;}

        return n * factorial(n-1);
    }

    /**
     * Factorial with the help of accumulators
     */
    public static int factorial(int accumulator, int n) {
        if (n == 1) {return accumulator;}

        return factorial(n * accumulator, n-1);
    }

    public static void main(String args[]) {
        System.out.println(factorial(30));
        // Accumulators way
        System.out.println(factorial(1, 30));
    }
}
