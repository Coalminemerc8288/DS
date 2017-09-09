package com.pbhatna.linkedlist;

/**
 * Check if a linked list of strings forms a palindrome
 *
 * Input  : a -> bc -> d -> dcb -> a -> NULL
 * Output : True
 * String "abcddcba" is palindrome.
 *
 *
 * Input : a -> bc -> d -> ba -> NULL
 * Output : False
 * String "abcdba" is not palindrome.
 *
 */
public class Palindrome<T extends Comparable<T>> extends LinkedList {

    public boolean isPalindrome(Node<T> head) {
        if (head == null) {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        Node<T> curr = head;
        while(curr != null) {
            sb.append(curr.getData());
            curr = curr.getNext();
        }

        String s = sb.toString();
        System.out.println(s.toString());

        char [] arr = s.toCharArray();

        int indexA = 0;
        int indexB = arr.length-1;

        System.out.println(indexB);

        for (int i =0; i < arr.length; i++) {
            if (arr[indexA] != arr[indexB]) {
                return false;
            }
            indexA++;
            indexB--;
        }
        return true;
    }
}
