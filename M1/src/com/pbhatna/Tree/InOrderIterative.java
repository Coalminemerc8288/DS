package com.pbhatna.Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 */
public class InOrderIterative {

    public static List<Integer> inOrderIterative(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<Node>();
        Node p = root;

        while (!stack.isEmpty() || p!= null) {

            //if not null go down the tree to the left
            if (p != null) {
                stack.push(p);
                p = p.getLeftChild();

            } else {
                // if no child left, pop element and process
                // and move pointer to the right
                Node t = stack.pop();
                result.add((Integer) t.getData());
                p = t.getRightChild();
            }
        }
        return result;
    }
}
