package com.pbhatna.core.Implementations.trees.binarytrees;

import com.pbhatna.core.Implementations.trees.Node;

public class BinaryTreePostOrder {

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        print(root);

    }
    public void print(Node node) {
        System.out.print(node.getData() + "->");
    }
}
