package com.pbhatna.Tree;

/**
 *
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * in-order:   4 2 5  (1)  6 7 3 8
 * post-order: 4 5 2  6 7 8 3  (1)
 *
 * Solution: From the post-order array, we know that last element is the root. We can find the root in in-order array.
 * Then we can identify the left and right sub-trees of the root from in-order array.
 * Using the length of left sub-tree, we can identify left and right sub-trees in post-order array.
 * Recursively, we can build up the tree.
 *
 */
public class BinaryTreeFromInOrderAndPostOrder {

    public Node buildTree(int[] inOrder, int [] postOrder) {
        int inStartIndex = 0;
        int inEndIndex = inOrder.length-1;
        int postStartIndex = 0;
        int postEndIndex = postOrder.length-1;
        return constructTree(inOrder, inStartIndex,inEndIndex,postOrder, postStartIndex, postEndIndex);
    }

    private Node constructTree(
            int [] inOrder,
            int inStartIndex,
            int inEndIndex,
            int [] postOrder,
            int postStartIndex,
            int postEndIndex
    ) {

        if (inStartIndex > inEndIndex || postStartIndex > postEndIndex ) {
            return null;
        }

        // Since first node in pre order is the root
        int val = postOrder[postEndIndex];
        Node p = new Node(val);

        // find that same first node in the in order and
        // divide the array into two sub parts
        int k =0;
        for (int i=0; i < inOrder.length-1;i++ ) {
            if (val == inOrder[i]) {
                k = i;
                break;
            }
        }

        // build left and right sub tree
        // k-inStartIndex  provides length/elements in InOrder Array
        // Pick same no of elements from preOrder(preStartIndex+(k-inStartIndex))

        p.setLeftChild(constructTree(inOrder, inStartIndex, k-1, postOrder,postStartIndex, postStartIndex + k-(inStartIndex+1)));
        p.setRightChild(constructTree(inOrder, k+1, inEndIndex , postOrder, postStartIndex + k-inStartIndex, postEndIndex));
        return p;
    }
}
