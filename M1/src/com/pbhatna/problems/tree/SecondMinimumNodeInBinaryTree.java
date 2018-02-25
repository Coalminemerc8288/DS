package com.pbhatna.problems.tree;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node.
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Solution: Find first and second minimum on both left and right subtrees, compare the two and
 * return minimum of them as well. Also consider the case if left or right subtree return -1 before finding second minimum
 */
public class SecondMinimumNodeInBinaryTree {

    public int findSecondMinimumValue(Node root) {

        if (root == null) {
            return -1;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return -1;
        }

        // Get value of left and right child nodes
        int left = (int) root.getLeftChild().getData();
        int right =(int) root.getRightChild().getData();

        // if first minimum found in the left subtree
        if (left == (int) root.getData()) {
            left = findSecondMinimumValue(root.getLeftChild());
        }

        // if first minimum found in the right subtree
        if (right == (int) root.getData()) {
            right = findSecondMinimumValue(root.getRightChild());
        }

        // once we found min on both the subtrees return the minimum
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

}
