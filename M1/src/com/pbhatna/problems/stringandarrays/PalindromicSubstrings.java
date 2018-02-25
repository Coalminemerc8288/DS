package com.pbhatna.problems.stringandarrays;

/**
 *  Given a string, your task is to count how many palindromic substrings in this string.

 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Solution:
 *
 * Step 1: Start a for loop to point at every single character from where we will trace the palindrome string.
 * checkPalindrome(s,i,i); //To check the palindrome of odd length palindromic sub-string
 * checkPalindrome(s,i,i+1); //To check the palindrome of even length palindromic sub-string
 *
 * Step 2: From each character of the string, we will keep checking if the sub-string is a palindrome
 * and increment the palindrome count. To check the palindrome, keep checking the left and right of
 * the character if it is same or not.
 */
public class PalindromicSubstrings {

    private static int count = 0;

    public static int countSubstrings(String s) {
        if (s.length() == 0) {return 0;}

        for (int i =0; i < s.length(); i++) {
            checkPalindromicString(s, i, i); // odd length palindromic substring
            checkPalindromicString(s, i , i+1); // even length palindromic substring
        }
        return count;
    }

    private static void checkPalindromicString(String s, int i, int j) {
        while (i >=0 && j <s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }

    public static void main(String args[]) {
          System.out.println(countSubstrings("abc"));
    }
}
