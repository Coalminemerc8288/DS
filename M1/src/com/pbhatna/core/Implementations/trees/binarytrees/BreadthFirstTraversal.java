package com.pbhatna.core.Implementations.trees.binarytrees;

import com.pbhatna.core.Implementations.trees.Node;

import java.util.Queue;
import java.util.ArrayDeque;

public class BreadthFirstTraversal {

    public void breadthFirstTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            print(node);

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }
}
