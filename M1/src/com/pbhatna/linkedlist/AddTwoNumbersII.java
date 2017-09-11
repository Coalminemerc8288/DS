package com.pbhatna.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersII extends LinkedList{

    public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        int carry = 0;


        Node<Integer> l3 = new Node<Integer>(0);

        Node<Integer> p1 = reverseList(l1);
        Node<Integer> p2 = reverseList(l2);
        Node<Integer> p3 = l3;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry = carry + (int) p1.getData();
                p1 = p1.getNext();
            }

            if (p2 != null) {
                carry = carry + (int) p2.getData();
                p2 = p2.getNext();
            }
            p3.setNext(new Node<Integer>(carry % 10));
            carry = carry/ 10;
            p3 = p3.getNext();
        }

        if(carry == 1) {
            p3.setNext(new Node<Integer>(carry));
        }

        l3 = reverseList(l3.getNext());
        return l3.getNext();
    }

    public static Node<Integer> reverseList(Node<Integer> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        while (curr != null) {
            Node<Integer> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // creating first list:  75946
        list.addNode(7);
        list.addNode(5);
        list.addNode(9);
        list.addNode(4);
        list.addNode(6);

        System.out.print("First List is \n\n");
        list.printNodes();

        // creating seconnd list : 84
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addNode(8);
        list1.addNode(4);
        System.out.print("Second List is \n\n");
        list1.printNodes();

        // add the two lists and see the result
        Node<Integer> rs = addTwoNumbers(list.getHead(), list1.getHead());
        System.out.print("Resultant List is \n\n");
        printNodes(rs);
    }
}
