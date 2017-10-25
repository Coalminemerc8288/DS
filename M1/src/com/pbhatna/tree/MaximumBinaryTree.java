package com.pbhatna.Tree;

import com.pbhatna.Tree.printer.BTreePrinter;

/**
 * Given an integer array with no duplicates.
 *
 * A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:

        6
     /   \
    3     5
    \    /
     2  0
     \
     1
 Note:
 The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {

    public static Node getMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return build(nums, 0, nums.length -1);
    }

    public static Node build(int[] nums, int start, int end) {
        if (start > end) {
            //base case
            return null;
        }

        int maxIndex = start;
        for (int i = start+1; i< end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        Node root = new Node(nums[maxIndex]);
        root.setLeftChild(build(nums, start, maxIndex-1));
        root.setRightChild(build(nums, maxIndex+1, end));

        return root;
    }


    public static void main(String[]args) {
        int [] nums = {3,2,1,6,0,5};
        Node root = getMaximumBinaryTree(nums);
        BTreePrinter.printNode(root);
    }
}
