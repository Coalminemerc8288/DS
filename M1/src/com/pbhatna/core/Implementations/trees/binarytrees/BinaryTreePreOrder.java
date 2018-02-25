package com.pbhatna.core.Implementations.trees.binarytrees;

import com.pbhatna.core.Implementations.trees.Node;

public class BinaryTreePreOrder {

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }

        print(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }
    public void print(Node<Character>node) {
        System.out.print(node.getData() + "->");
    }
}
