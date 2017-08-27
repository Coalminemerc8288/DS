package com.pbhatna.Tree;

/**
 * Maximum depth of the binary tree
 */
public class MaxDepthOfBinaryTree {

    public static int maxDepth(Node<Character> root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }

        int left = 1 + maxDepth(root.getLeftChild());
        int right = 1 + maxDepth(root.getRightChild());

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> x = new Node<>('X');

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        g.setLeftChild(x);

        System.out.println("Max Depth: " + maxDepth(a));
    }


}
