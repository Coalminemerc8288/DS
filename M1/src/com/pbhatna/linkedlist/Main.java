package com.pbhatna.linkedlist;


public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> n = new LinkedList<Integer>();
        n.addNode(3);
        n.addNode(4);
        n.addNode(5);
        n.addNode(10);

        System.out.println("Printing all nodes through printnode function" );
        n.printNodes(); //  to print all the nodes

        System.out.println("Using countNodes function, printing total number of nodes which is  " + n.countNodes());

        System.out.println("Using popelemenet function,Popping the top node from the list whose value is " + n.popElement());
        System.out.println("Printing all nodes through printnode function after pop function" );
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
