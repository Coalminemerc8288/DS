package com.pbhatna.core.Implementations.linkedlist;

import java.util.List;
import java.util.ArrayList;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

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
            curr.setNext(new Node(data));
        }
    }

    /**
     * Print all the nodes in the linked list.
     */
    public void printNodes() {
        if (head == null) {
            System.out.println("There is no node in the linked list");
        } else {
            Node<T> curr = head;
            int i = 1;
            while (curr != null) {
                System.out.println("Node<T> number " + i + ", the value it stores is " + curr.toString());
                curr = curr.getNext();
                i++;
            }
        }
    }

    /**
     * Count the number of nodes in the linked list.
     */
    public int countNodes() {
        if (head == null) {
            return 0;
        } else {
            Node<T> curr = head;
            int count = 0;
            while (curr != null) {
                curr = curr.getNext();
                count++;
            }
            return count;
        }
    }

    /**
     * Return the first element in the linked list.
     */
    public T popElement() {
        if (head != null) {
            T topElement = head.getData();

            head = head.getNext();

            return topElement;
        }

        return null;
    }

    /**
     * Delete all the elements in the linked list.
     */
    public void deleteLinkedList() {
        head = null;
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insertNth(int n, T data) {
        if (n > countNodes()) {
            return;
        }

        if (n == 0) {
            // To insert at the 0th position update the head itself.
            Node<T> nextNode = head;
            head = new Node(data);
            head.setNext(nextNode);
        } else {
            // Move the curr node to one before the position where we
            // want to insert the element and adjust the pointers accordingly.
            int i = 0;
            Node<T> curr = head;
            while (i < n - 1) {
                curr = curr.getNext();
                i++;
            }
            Node<T> next = curr.getNext();

            curr.setNext(new Node<T>(data));
            curr.getNext().setNext(next);
        }
    }

    /**
     * Insert the data into the correct position in a sorted list. Assume
     * that the list is sorted in ascending order.
     */
    public void insertAtSortedList(T data) {
        // If list is empty or first node is bigger than added element
        if (countNodes() == 0 || head.getData().compareTo(data) > 0) {
            Node<T> next = head;
            head = new Node<T>(data);
            head.setNext(next);
        } else {
            // If node is not empty
            Node<T> curr = head;
            while (curr.getNext() != null &&  curr.getData().compareTo(data) < 0) {
                curr = curr.getNext();
            }
            Node<T> next = curr.getNext();
            curr.setNext(new Node<T>(data));
            curr.getNext().setNext(next);
        }
    }

    /**
     * Append the nodes of the other list to the end of the curren list.
     */
    public void appendList(LinkedList l1) {
        if (l1.head == null) {
            return;
        } else {
            Node<T> curr = l1.head;
            while (curr.getNext() != null) {
                addNode(curr.getData());
                curr.getNext();
            }
        }
    }

    /**
     * Split a linked list into 2 equal parts. If there are an odd number of
     * elements, the extra element should be in the first list.
     */
    public List<Node<T>>frontBackSplit() {
        Node<T> front = null;
        Node<T> back = null;

        if (head == null) {
            front = null;
            back = null;
        } else if (head.getNext() == null) {
            //List has one element in the list and it should go to first list
            front = head;
            back = null;
        } else {
            // Use slow and fast pointers to split the list
            Node<T> slow = head;
            Node<T> fast = head;

            while (fast.getNext() != null && fast.getNext().getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
            // Splitting the two
            front = head;
            back = slow.getNext();
            slow.setNext(null);
        }

        List<Node<T>> list = new ArrayList<>();
        list.add(front);
        list.add(back);

        return list;
    }

    /**
     * Remove duplicates in a sorted list.
     */
    public void removeDuplicates() {
        if (countNodes() == 0 || countNodes() == 1) {
            return;
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                if (curr.getData().compareTo(curr.getNext().getData()) == 0) {
                    // skip the node and that will be garbage collected by Java
                    Node<T> next = curr.getNext().getNext();
                    curr.setNext(next);
                } else {
                    curr= curr.getNext();
                }
            }
        }
    }

    /**
     * Create a new sorted list which is the merged from two original sorted lists.
     * Assume the lists are sorted in ascending order.
     */
    public LinkedList<T> sortedMergeList(LinkedList l2) {
        if (l2 == null) {
            return this;
        } else if (head == null) {
            return l2;
        } else {
            Node<T> curr1 = head;
            Node<T> curr2 = l2.head;

            LinkedList<T> sortedList = new LinkedList<T>();
            while (curr1!= null || curr2 != null) {
                if (curr1.getData().compareTo(curr2.getData()) < 0) {
                    sortedList.addNode(curr1.getData());
                    curr1 = curr1.getNext();
                } else {
                    sortedList.addNode(curr2.getData());
                    curr2 = curr2.getNext();
                }
            }
            return sortedList;
        }
    }

    /**
     * Reverse all the nodes in the linked list so that the last node
     * becomes the first node.
     */
    public void reverseList() {
         if (head == null|| head.getNext() == null) {
             return;
         }

         Node<T> prev = null;
         Node<T> curr = head;

         while (curr != null) {
             Node<T> next = curr.getNext();
             curr.setNext(prev);
             prev = curr;
             curr = next;
         }
         head = prev;
    }
}
