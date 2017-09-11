package com.pbhatna.stringandarrays;

/**
 * Is the given number palindrome(similar to reverse integer problem)
 */
public class IsNumberPalindrome {
    public static boolean isPalindrome(int num) {
        int result = 0;
        int curr = num;
        while (num != 0) {
            result = result * 10 + num % 10;
            num = num /10;
        }
        return result == curr;
    }

    public static void main(String[] args) {
        int k = 12321;
        System.out.println("Is the given number palindrome?.."+ k + isPalindrome(k));
    }
}
