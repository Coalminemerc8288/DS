package com.pbhatna.linkedlist;

/**
 * Delete all the elements in the linked list.
 */
public class deleteLinkedList<T extends Comparable<T>> extends LinkedList  {

    public void deleteLinkedList() {
        // This is the easiest code every written in Java, no clean up
        // required. Java's garbage collector will clean up the memory
        // for all the elements being used in this linked list if
        // they are no longer referenced in the program.
        head = null;
    }
}
