package com.pbhatna.stringandarrays;

/**
 * Check if given string is a palindrome without extra s
 */
public class IsStringPalindrome {
    public static boolean isPalindrome(String s) {
        char[] array  = s.toCharArray();
        int p1 = 0;
        int p2 = array.length-1;
        while (p1 < p2) {
            if (array[p1] != array[p2]) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
    public static void main(String []args) {
       String s ="aabcbaa";
       System.out.println("Is the given string "+ s +" palindrome:"+isPalindrome(s));

    }
}
