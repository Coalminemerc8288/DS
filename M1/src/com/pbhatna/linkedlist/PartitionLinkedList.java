package com.pbhatna.linkedlist;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 * Solution: Idea is to instantiate three separate list (smaller, larger and equal) to keep track of nodes,
 * add appropriate nodes to the relevant head and in the last join all the three
 *
 */
public class PartitionLinkedList extends LinkedList {

    public static Node<Integer> getPartitionedList(Node<Integer> head, int n) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> curr = head;
        Node<Integer> smaller = new Node<>(0);
        Node<Integer> equal = new Node<>(0);
        Node<Integer> larger = new Node<>(0);

        Node<Integer> smallerStart = smaller;
        Node<Integer> equalStart = equal;
        Node<Integer> largerStart = larger;

        while (curr != null) {
            if (curr.getData() == n) {
                equal.setNext(curr);
                equal = equal.getNext();
            } else if (curr.getData() < n) {
                smaller.setNext(curr);
                smaller = smaller.getNext();
            } else if (curr.getData() > n) {
                larger.setNext(curr);
                larger = larger.getNext();
            }
            curr = curr.getNext();
        }

        larger.setNext(null);
        equal.setNext(largerStart.getNext());
        smaller.setNext(equalStart.getNext());

        return smallerStart.getNext();
    }

    public static void main(String [] args) {

        LinkedList<Integer> list = new LinkedList<>();

        // creating first list
        list.addNode(1);
        list.addNode(4);
        list.addNode(3);
        list.addNode(2);
        list.addNode(5);
        list.addNode(2);

        System.out.print("First List is \n\n");
        list.printNodes();

        Node<Integer> list1 = getPartitionedList(list.getHead(), 3);
        printNodes(list1);
    }
}

