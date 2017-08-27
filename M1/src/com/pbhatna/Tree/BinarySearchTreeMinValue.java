package com.pbhatna.Tree;

/**
 *
 * Find Minimum value
 */
public class BinarySearchTreeMinValue {

    public static int minValue(Node<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.getLeftChild() == null) {
            return root.getData();
        }

        return minValue(root.getLeftChild());
    }
}
