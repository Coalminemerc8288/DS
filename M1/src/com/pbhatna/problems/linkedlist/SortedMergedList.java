package com.pbhatna.linkedlist;

/**
 * Create a new sorted list which is the merged from two original sorted lists.
 * Assume the lists are sorted in ascending order.
 */
public class SortedMergedList<T extends Comparable<T>> extends LinkedList  {
    public LinkedList<T> sortedMergeList(LinkedList otherList) {
        if (otherList == null) {
            return this;
        } else if (head == null) {
            return otherList;
        } else {
            Node<T> curr1 = otherList.head;
            Node<T> curr2 = head;
            LinkedList<T> sortedList = new LinkedList<T>();

            while (curr1 != null || curr2 != null) {
                if (curr2 == null ||
                        (curr1 != null && curr1.getData().compareTo(curr2.getData()) < 0)) {
                    sortedList.addNode(curr1.getData());
                    curr1 = curr1.getNext();
                }
                else {
                    sortedList.addNode(curr2.getData());
                    curr2 = curr2.getNext();
                }
            }

            return  sortedList;
        }
    }
}
