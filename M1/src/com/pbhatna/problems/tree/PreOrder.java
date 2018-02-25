package com.pbhatna.problems.tree;

/**
 * Pre Order Traversal
 */
public class PreOrder {
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        print(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());

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

        preOrder(a);
    }

    public static void print(Node<Character>node) {
        System.out.print(node.getData() + "->");
    }

}

