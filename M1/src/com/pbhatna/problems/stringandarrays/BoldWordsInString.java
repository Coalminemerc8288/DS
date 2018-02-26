package com.pbhatna.problems.stringandarrays;


/**
 * Question758: BoldWordsInString
 *
 * Solution: The main idea is to use a boolean array to mark words at the corresponding position
 * and then build a final string based on the marked positions
 *
 */
public class BoldWordsInString {

    public String boldWords(String[] words, String s) {
        if (words == null || words.length == 0) { return ""; }   // basic validation

        // mark words
        boolean[] marked = new boolean [s.length()];
        for (String word: words) {
            markWords(s, word, marked);
        }

        // rebuild string
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (marked[i] && (i==0 || !marked[i-1])) {
                sb.append("<b>");
            }

            sb.append(s.charAt(i));

            if (marked[i] && (i == s.length()-1 || !marked[i+1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    public void markWords(String s, String word, boolean[] marked) {
        // Iterate through complete string
        for (int i = 0; i < s.length() - word.length(); i++) {
            String substring = s.substring(i, i+ word.length());

            // if substring matches word, marked them true
            if (substring.equals(word)) {
                for (int j = i; j < i+ word.length(); j ++) {
                    marked[j] = true;
                }
            }
        }
    }
}
