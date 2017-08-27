package com.pbhatna.Tree;

import com.pbhatna.Tree.printer.BTreePrinter;

/**
 * Mirror Binary Tree
 */
public class MirrorBinaryTree {

    public static void mirror(Node<Integer> root) {
        if (root == null) {
            return;
        }

        //recursive call on both left and right sub trees
        mirror(root.getLeftChild());
        mirror(root.getRightChild());

        // swap
        Node<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    public static void main(String[] args) throws
            Queue.QueueUnderflowException, Queue.QueueOverflowException {
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

        three.setLeftChild(one);
        three.setRightChild(nine);
        nine.setLeftChild(two);
        nine.setRightChild(four);
        one.setLeftChild(six);
        six.setRightChild(seven);
        six.setLeftChild(ten);
        two.setRightChild(five);
        four.setLeftChild(eight);
        four.setRightChild(eleven);

        System.out.println("\tOriginal");
        BTreePrinter.printNode(three);

        mirror(three);
        System.out.println();
        System.out.println("\tMirror");
        BTreePrinter.printNode(three);
    }

    public static void breadthFirst(Node root) throws
            Queue.QueueUnderflowException, Queue.QueueOverflowException {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new Queue<>(Node.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            print(node);

            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }


    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }
}
