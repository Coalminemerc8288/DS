package com.pbhatna.Tree;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *  Example:
 *  Given the sorted linked list: [-10,-3,0,5,9],
 *  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
     *
     */
public class SortedListToBinary {

    public Node sortedListToBST(com.pbhatna.linkedlist.Node head) {
        if (head == null) {
            return null;
        }
        return convertToBST(head, null);
    }

    private Node convertToBST(com.pbhatna.linkedlist.Node head, com.pbhatna.linkedlist.Node tail) {
        com.pbhatna.linkedlist.Node slow = head;
        com.pbhatna.linkedlist.Node fast = head;

        // base case
        if (head == tail) return null;

        // break the list
        while (fast!= tail && fast.getNext().getNext()!= tail) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // get root node for each iteration
        Node node = new Node(slow.getData());
        node.setLeftChild(convertToBST(head, slow));
        node.setRightChild(convertToBST(slow.getNext(), tail));

        return node;
    }
}
