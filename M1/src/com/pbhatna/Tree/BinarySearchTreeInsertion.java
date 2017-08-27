package com.pbhatna.Tree;

import com.pbhatna.Tree.printer.BTreePrinter;

/**
 * Binary Search Tree Insertion
 *
 * Average Case : O(log n)
 * Wost Case: O(n)
 */
public class BinarySearchTreeInsertion {

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

        Node<Integer> head = insert(null, five);

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        inOrder(head);
    }

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
}

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }
}
