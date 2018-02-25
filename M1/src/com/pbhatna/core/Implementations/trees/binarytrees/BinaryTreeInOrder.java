package com.pbhatna.core.Implementations.trees.binarytrees;

import com.pbhatna.core.Implementations.trees.Node;

public class BinaryTreeInOrder {

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }

    public void print(Node node) {
        System.out.print(node.getData() + "->");
    }
}
