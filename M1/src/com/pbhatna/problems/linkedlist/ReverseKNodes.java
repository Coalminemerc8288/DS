package com.pbhatna.problems.linkedlist;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 *  1->2->3->4->5
 *
 *  k=2, 2->1->3->4->5
 *
 *  k=4, 4->3->2->1->5
 */
public class ReverseKNodes extends LinkedList {

    public static Node<Integer> reverseKNodes(Node<Integer> head, int k) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> first = head;

        int i = 0;
        while (i < k) {
            prev = curr;
            curr = curr.getNext();
            i++;
        }
        printNodes(curr);

        prev.setNext(null);
        printNodes(first);

        first = reverse(first);
        printNodes(first);

        Node<Integer> result = first;

        int j = 0;
        while(j < k-1) {
            first = first.getNext();
            j++;
        }
        first.setNext(curr);
        printNodes(result);

        return result;
    }


    public static Node<Integer> reverse(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> second = head.getNext();
        head.setNext(null);

        Node<Integer> result = reverse(second);
        second.setNext(head);

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // creating first list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        System.out.print("First List is \n\n");
        list.printNodes();

        Node<Integer> list1 = reverseKNodes(list.getHead(), 3);
        printNodes(list1);
    }
}
