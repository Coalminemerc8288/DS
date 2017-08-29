package com.pbhatna.tree;

/**
 * Check if Binary tree is the binary search tree
 */
public class BinaryTreeIsBST {

    public static boolean isBst(Node<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.getData() <= min || root.getData() > max) {
            return false;
        }

        return isBst(root.getLeftChild(), min, root.getData()) && isBst(root.getLeftChild(), root.getData(), max);
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        }

        if (node.getData() > head.getData()) {
            head.setRightChild(insert(head.getRightChild(), node));
        }

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);
        Node<Integer> eleven = new Node<>(11);

        Node<Integer> head = insert(null, five);

        insert(head, six);
        insert(head, one);
        insert(head, seven);
        insert(head, nine);
        insert(head, four);
        insert(head, three);
        insert(head, eight);
        insert(head, two);

        eight.setRightChild(eleven);

        System.out.println("Is BST: " + isBst(head, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }


}
