package com.pbhatna.core.recursion;

public class Recursion {
    /**
     * Recursion vs iteration
     */
    public static int recursiveSum(int N) {
        if (N == 1) { return 1;}

        return N + recursiveSum(N-1);
    }

    /**
     * Iteration
     */
    public static int iterativeSum(int N) {
        int result = 0;

        for(int i=0; i <= N; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String [] args) {
        System.out.println(recursiveSum(5));
        System.out.println(iterativeSum(5));
    }
}
