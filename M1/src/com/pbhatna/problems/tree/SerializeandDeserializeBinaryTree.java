package com.pbhatna.problems.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 *  For example, you may serialize the following tree
 *
 *  "[1,2,3,null,null,4,5]"

 */
public class SerializeandDeserializeBinaryTree {

    private static final String SPLITTER = ",";
    private static final String NULLNODE = "X";

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULLNODE).append(SPLITTER);
        } else {
            sb.append(root.getData()).append(SPLITTER);
            buildString(root.getLeftChild(), sb);
            buildString(root.getRightChild(), sb);
        }
    }

    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITTER)));
        return buildTree(queue);
    }

    public Node buildTree(Queue<String> queue) {
        String val = queue.remove();
        if (val.equals(NULLNODE)) {
            return null;
        } else {
            Node root  = new Node(Integer.valueOf(val));
            root.setLeftChild(buildTree(queue));
            root.setRightChild(buildTree(queue));
            return root;
        }
    }
}
