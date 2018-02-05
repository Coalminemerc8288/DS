package com.pbhatna.core.Impl.linkedlist;

public class LinkedList <T extends Comparable<T>> implements Cloneable {

    private Node<T> head = null;

    public LinkedList() {}

    /**
     * Append a new node to the end of the linked list.
     */
    public void addNode(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<T> (data));
        }
    }

    /**
     * Print all the nodes in the linked list.
     */
    public void printNodes(Node<T> head) {
        if (head == null) {
            System.out.println("No nodes exist");
        } else {
            Node<T> curr = head;
            int i = 0;
            while (curr.getNext() != null) {
                System.out.println("Node " + curr.getData());
                curr = curr.getNext();
                i++;
            }
        }
    }

    /**
     * Count the number of nodes in the linked list.
     */
    private int countNodes(Node<T> head){
        if (head == null) {
            return 0;
        } else {
            Node<T> curr = head;
            int i = 0;
            while(curr.getNext() != null) {
               curr = curr.getNext();
                i++;
            }
            return i;
        }
    }

    /**
     * Return the first element in the linked list.
     */
    public T popElement() {
        if (head == null) {
            return null;
        }

        T topElement = head.getData();
        head = head.getNext();

        return topElement;
    }

    /**
     * Delete all the elements in the linked list.
     */
    public void deleteLinkedList() {
        // This is the easiest code every written in Java, no clean up
        // required. Java's garbage collector will clean up the memory
        // for all the elements being used in this linked list if
        // they are no longer referenced in the program.
        head = null;
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insert(int n, T data) {
     if (n > countNodes(head)) {
         return;
     }

     if (n == 0) {
         // could be at the head
         Node<T> next = head;
         head = new Node(data);
         head.setNext(next);
     } else {
         // Move the curr node to  one before the position we would like to add new node
         int i = 0;
         Node<T> curr = head;
         while (i < n-1) {
             curr = curr.getNext();
             i++;
         }
         Node<T> next = curr.getNext();
         curr.setNext(new Node(data));
         curr.getNext().setNext(next);
     }
    }

    /**
     * Insert the data into the correct position in a sorted list. Assume
     * that the list is sorted in ascending order.
     */


    /**
     * Append the nodes of the other list to the end of the curren list.
     */


    /**
     * Split a linked list into 2 equal parts. If there are an odd number of
     * elements, the extra element should be in the first list.
     */


    /**
     * Remove duplicates in a sorted list.
     */


    /**
     * Move the head element or the first element from this list to
     * the destination linked list as the destination's new head node.
     */

    /**
     * Create a new sorted list which is the merged from two original sorted lists.
     * Assume the lists are sorted in ascending order.
     */

    /**
     * Reverse all the nodes in the linked list so that the last node
     * becomes the first node.
     */

}
