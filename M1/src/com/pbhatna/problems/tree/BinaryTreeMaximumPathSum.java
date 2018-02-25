package com.pbhatna.problems.tree;

/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * For example:
 *
 * Given the below binary tree,
 *
 *    1
 *   / \
 *  2   3
 *
 *  Solution:
 *  Starting from the root, will calculate the max path sum recursively in the left and the right subtrees
 */
public class BinaryTreeMaximumPathSum {

    private int maxValue;

    public int maxPathSum(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(Node root) {
        if (root == null) {
            return 0;  //base case
        }

        // recursive fetch maxValue on the left and right subtree
        int left = Math.max(0, maxPathDown(root.getLeftChild()));
        int right = Math.max(0, maxPathDown(root.getRightChild()));

        // Update max value if needed
        maxValue = Math.max(maxValue, (left + right+ (int)root.getData()));

        // return whichever is greater(left or right) plus the root node value
        return Math.max(left, right) +(int)root.getData();
    }
}
