package com.pbhatna.linkedlist;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class RandomPointerDeleteNode extends LinkedList {

    public static void deleteNode(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Node<Integer> curr = node;
        if (curr.getNext() != null && curr.getNext().getNext() != null) {
            curr.setData(curr.getNext().getData());
            curr.setNext(curr.getNext().getNext());
        }
        printNodes(node);
    }

    public static void main(String[] args) {

        LinkedList<Integer> n = new LinkedList<Integer>();
        n.addNode(1);
        n.addNode(2);
        n.addNode(3);
        n.addNode(4);

        System.out.println("Printing all nodes through printnode function" );
        n.printNodes(); //  to print all the nodes

        deleteNode(n.getHead().getNext());
        n.printNodes();
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