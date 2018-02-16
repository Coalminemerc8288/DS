package com.pbhatna.stringandarrays;


/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 *  Solution: Use two pointers and do the same palindrome test if characters are not equal then
 *  sudo skip the letter(either left or right by 1) and do the palindrome test
 */

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i =0;
        int j = s.length() - 1;

        // two pointers check
        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        // valid
        if (i >= j) { return true; }

        if (isPalindrome(s, i+1, j) || isPalindrome(s, i,j+1)) { return true;}

        return false;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else { return false;}
        }
        return false;
    }
}
