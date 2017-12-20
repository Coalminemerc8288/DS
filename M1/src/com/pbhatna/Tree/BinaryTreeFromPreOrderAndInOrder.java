package com.pbhatna.Tree;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * in-order:   4 2 5 (1) 6 7 3 8
 * pre-order: (1) 2 4 5  3 7 6 8
 *
 * Solution: From the pre-order array, we know that first element is the root.
 * We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
 * Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. Recursively, we can build up the tree.
 */
public class BinaryTreeFromPreOrderAndInOrder {

    public Node buildTree(int [] preOrder, int[] inOrder) {
        int preStartIndex = 0;
        int preEndIndex = preOrder.length-1;
        int inStartIndex = 0;
        int inEndIndex = inOrder.length-1;

        return constructTree(preOrder, preStartIndex, preEndIndex ,inOrder, inStartIndex,inEndIndex );
    }

    private Node constructTree(
            int [] preOrder,
            int preStartIndex,
            int preEndIndex,
            int [] inOrder,
            int inStartIndex,
            int inEndIndex
            ) {

       if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
       }

       // Since first node in pre order is the root
       int val = preOrder[preStartIndex];
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

        p.setLeftChild(constructTree(preOrder, preStartIndex+1, preStartIndex+(k-inStartIndex),inOrder, inStartIndex, k-1 ));
        p.setRightChild(constructTree(preOrder, preStartIndex + (k-inStartIndex)+1 ,preEndIndex, inOrder, k+1, inEndIndex));

        return p;
    }
}
