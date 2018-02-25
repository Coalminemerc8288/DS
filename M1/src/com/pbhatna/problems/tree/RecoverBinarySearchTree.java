package com.pbhatna.problems.tree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {

    Node first  = null;
    Node second = null;

    Node prev = new Node(Integer.MIN_VALUE);

    public void recoverTree(Node root) {

        // run in order traversal, by the end of traversal we have both the nodes that's
        // at incorrect position
        inOrder(root);

        //swap nodes, correct the order
        int temp = (int) first.getData();
        first.setData(second.getData());
        second.setData(temp);

    }

    private void inOrder(Node root) {
        if (root == null) {             //base case
            return;
        }

        inOrder(root.getLeftChild());  //left subtree traversal

        // In order prints the elements in the increasing order, so if previous element
        // is greater than current that means we found our incorrect elements
        if (first == null && (prev.getData().compareTo(root.getData()) > 0)) {            //first catch
            first.setData(root.getData());
        }
        if (first != null && prev.getData().compareTo(root.getData()) > 0) {              //second catch
            second.setData(root.getData());
        }
        prev = root;

        inOrder(root.getRightChild());  //right subtree traversal
    }
}
