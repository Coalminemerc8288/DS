package com.pbhatna.problems.advanced.recursion;

/**
 * TowerOfHanoi with Recursion
 *
 * 1. It consist of three rods with number of disks which can slide
 * on to any rod
 *
 * 2. Puzzle stack with disk in the neat stack in ascending order of size
 * one on the rod, smallest at the top making canonical shape
 *
 * 3. The minimum number of moves required to solve the problem
 * is : 2^n -1  O(2^n) Exponential time complexity
 *
 *  Rules:
 *      1. One disk can be moved at a time
 *      2. Each move consist of taking the upper disk at one stack and
 *      placing on top of another
 *      3. No disk can be placed on top of smaller disk
 *
 */
public class TowerOfHanoiProblem {
    /**
     * @param n Number of plates to move
     * @param rodFrom To move plates from
     * @param rodMiddle Auxiliary helper rod
     * @param rodTo To move plates to
     */
    public static void solveHanoi(int n, char rodFrom, char rodMiddle, char rodTo) {
        if (n == 1) {
            System.out.println("Plate 1 from " + rodFrom + " to " + rodTo);
            return;
        }
        solveHanoi(n-1, rodFrom, rodTo, rodMiddle);            // shift n-1 plates from rodFrom to rodMiddle with help of rodTo
        System.out.println("Plate "+ n +" from " + rodFrom + " to " + rodTo);   // move last final plate in the rodFrom
        solveHanoi(n-1, rodMiddle, rodFrom, rodTo);            // shift n-1 plates from rodMiddle to rodTo with help of rodFrom

    }
    public static void main(String[] args) {
        solveHanoi(10, 'A','B','C');
    }
}
