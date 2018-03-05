package com.pbhatna.problems.dynamicprogramming;
import java.util.Map;
import java.util.HashMap;

public class Fibonacci {

    // Using Memoization
    private static Map<Integer, Integer> memoizeTable;

    public Fibonacci() {
        memoizeTable = new HashMap<>();
        memoizeTable.put(0,0);
        memoizeTable.put(1,1);
    }


    /**
     * With Memoization and Dynamic Programming
     * Good because O(n) running time with O(n) extra space
     *
     * Fibonacci Sequence : 0 1 1 2 3 5 8 13 21 34
     */
    public static int fibonacciDynamicProgramming(int n) {
        if (memoizeTable.containsKey(n)) {
            return memoizeTable.get(n);
        }

        memoizeTable.put(n-1, fibonacciDynamicProgramming(n-1));
        memoizeTable.put(n-2, fibonacciDynamicProgramming(n-2));

        int calculatedNumber = memoizeTable.get(n-1) + memoizeTable.get(n-2);
        memoizeTable.put(n, calculatedNumber);

        return calculatedNumber;
    }

    /**
     * Without Memoization
     * Bad because of the exponential running time
     *
     * Fibonacci Sequence : 0 1 1 2 3 5 8 13 21 34
     */
    public static int naiveFibonacci(int n) {
        if (n == 0) { return 0;}
        if (n == 1) { return 1;}

        return naiveFibonacci(n-1) + naiveFibonacci(n-2);
    }

    public static void main(String []args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("A " + naiveFibonacci(15));
        System.out.println("B "+ fibonacci.fibonacciDynamicProgramming(15));
    }
}
