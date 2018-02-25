package com.pbhatna.problems.tree;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Efficient solution: Divide and conquer, use the characteristics of binary search tree, search in left or right sub tree
 * depending on the target value. If target value k exist in the left/right subtree then that's the closest or else the nearest
 * element
 *
 * Simple Solution: Also, another solution could be store in order binary tree to the auxiliary array and the find the minimum
 * absolute difference between these elements
 */
public class FindClosestBinaryTreeValue {
    private int closestValue;
    private double min = Double.MAX_VALUE;

    public int findClosestBinaryTreeValue(Node root, double target) {
        findClosest(root, target);
        return closestValue;   //getting updated at each interval
    }

    private void findClosest(Node root, double target) {
        if (root == null) {
            return;//base case
        }

        if (Math.abs((double)root.getData() - target) < min) {
            min = Math.abs((double)root.getData() - target);   //reduce the outbound limit at each step
            closestValue = (int) root.getData();               // keep track of the last closest node
        }

        // search in left subtree if target value is less than root, else in right subtree
        if ((int) root.getData() < target) {
            findClosest(root.getLeftChild(), target);
        } else {
            findClosest(root.getRightChild(), target);
        }
    }
}
