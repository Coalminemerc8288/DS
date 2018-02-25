package com.pbhatna.problems.tree;

/**
 * tree Node
 */
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;


    public Node() {}

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
