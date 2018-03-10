package com.pbhatna.core.recursion;

/**
 * EuclideanAlgorithm: Greatest common divisor
 */
public class EuclideanAlgorithm {

    /**
     * Iterative Approach
     */
    public static int iterativeGCD(int num1, int num2) {

        while (num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
       }
       return num1;
    }

    /**
     * Recursive Approach
     */
    public static int recursiveGCD(int num1, int num2) {
        if (num2 == 0) {return num1;}

        return recursiveGCD(num2, num1 % num2);
    }

    public static void main(String args[]) {

        System.out.println(iterativeGCD(20,16));
        // Accumulators way
        System.out.println(recursiveGCD(20, 16));
    }
}
