package com.pbhatna.problems.stringandarrays;

/**
 * Question557: BoldWordsInString
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 */
public class ReverseWordInString {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        String [] str = s.split(" ");


        for (String string: str) {
            StringBuilder temp = new StringBuilder();
            sb.append(temp.reverse());          // if reverse is not allowed, own swap function can be used
            sb.append(" ");
        }

        return sb.toString();
    }
}
