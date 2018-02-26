package com.pbhatna.problems.stringandarrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Solution: Idea is to maintain hash map with character and index location of character in a string
 *
 *  keep two pointers i and j(this is like a window problem) i traverse to the right and with the help of both
 *  we can find the length of substring. If we find charcter in a hashmap then, we find the index and move right pointer j
 *  to next location of the last found character.
 *
 *  Keep filling the hashmap while traversing, also keep updating the max in each iteration
 */
public class LongestSubstringWithOutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0,j=0; i <s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public static void main(String[] args){
      System.out.println(lengthOfLongestSubstring("pwpwkewkew"));
    }

}
