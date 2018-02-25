package com.pbhatna.problems.stringandarrays;

/**
 * Can be solved using binary representation
 *
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * 1) Elements in a subset must be in non-descending order.
 * 2) The solution set must not contain duplicate subsets.
 */
public class FindAllSubsetOfSet {
    public static void printSubsets(char[] set) {
        int length = set.length;

        System.out.println(length);
        //Review binary operations first, else this doesnt make sense
    }

    public static void main(String [] args) {
        char c[] = {'a', 'b', 'c'};
        printSubsets(c);
    }
}
