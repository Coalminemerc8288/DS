package com.pbhatna.problems.stringandarrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

/**
 * 522. Longest Uncommon Subsequence II
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * Note:
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 *
 *
 * Solution:
 * 1) Sort the characters in reverse order and if there are no duplicates then longest
 * one is the answer
 *
 * 2) If there are duplicates then, longest string is NOT the answer because
 * smaller string can be sub sequence of larger substring
 * -- For this reason we need to check if smaller substring is substring of rest of all
 * the strings bigger than itself, If it is not then its the answer.
 *
 */
public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {

        // Sort the string in reverse order
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Set<String> duplicates = getDuplicates(strs);
        for (int i = 0; i < strs.length; i ++) {
            if (!duplicates.contains(strs[i])) {
                for (int j = 0; j < i; j ++) {
                    if (isSubsequence(strs[j], strs[i])) { break; }
                    if (j == i-1) { return strs[i].length();}
                }
            }
        }
        return -1;

    }
    private boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
        }
        return j == b.length();
    }


    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();

        for (String s: strs) {
            if (set.contains(s)) {
                duplicates.add(s);
            }
            set.add(s);
        }
        return duplicates;
    }
}

