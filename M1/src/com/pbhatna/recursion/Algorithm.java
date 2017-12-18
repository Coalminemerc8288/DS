package com.pbhatna.recursion;

/**
 * Algorithm
 */
public class Algorithm {

    public int sumIterativeApproach(int n) {
        int result = 0;

        for(int i =0; i <=n; i++) {
            result = result +i;
         }
        return result;
    }
}
