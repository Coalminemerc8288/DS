package com.pbhatna.problems.tree;


/**
 * Breadth First Search
 */
public class BreadthFirstTraversal {

    public static void breadthFirstSearch(Node root) throws
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

    public static void main(String[] args) throws Queue.QueueUnderflowException, Queue.QueueOverflowException {
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
        b.setLeftChild(x);

        breadthFirstSearch(a);
    }
}
