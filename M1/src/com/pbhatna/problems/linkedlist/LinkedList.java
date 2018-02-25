package com.pbhatna.problems.linkedlist;

/**
 * linkedlist
 */
public class LinkedList<T extends Comparable<T>> {

    protected Node<T> head = null;

    public LinkedList() {}

    /**
     * Add Node
     */
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<T>(data));
        }
    }

    public void printNodes() {
        if (head == null) {
            System.out.println("No node exist");
        } else {
            int i = 0;
            Node<T> curr = head;
            while(curr != null) {
                System.out.println(" Node: " + i + " value: "+ curr.getData());
                curr = curr.getNext();
                i++;
            }
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public static void printNodes(Node<Integer> head) {
        System.out.println("--------------------");
        if (head == null) {
            System.out.println("No node exist");
        } else {
            int i = 0;
            Node<Integer> curr = head;
            while(curr != null) {
                System.out.println(" Node: " + i + " value: "+ curr.getData());
                curr = curr.getNext();
                i++;
            }
            System.out.println("--------------------");
        }
    }
}
