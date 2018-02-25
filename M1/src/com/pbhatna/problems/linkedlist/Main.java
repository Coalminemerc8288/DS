package com.pbhatna.problems.linkedlist;


public class Main {
    public static void main(String [] args) {
        LinkedList<String> l1 = new LinkedList<>();
        System.out.println(l1);
        l1.addNode("a");
        l1.addNode("bc");
        l1.addNode("d");
        l1.addNode("dcb");
        l1.addNode("a");

        l1.printNodes();

        Palindrome<String> p = new Palindrome();
        boolean flag = p.isPalindrome(l1.head);
        System.out.println(flag);
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
