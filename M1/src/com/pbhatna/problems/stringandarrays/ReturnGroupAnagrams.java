package com.pbhatna.problems.stringandarrays;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
    [
    ["ate", "eat","tea"],
    ["nat","tan"],
    ["bat"]
    ]
 *
 */
public class ReturnGroupAnagrams {

    public static  List<List<String>> getGroupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(0);
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);

            String key = String.valueOf(ca);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        // ["eat", "tea", "tan", "ate", "nat", "bat"],
        String [] strs = {"eat","tea", "tan", "ate","nat","bat"};

        System.out.println("--->"+ getGroupAnagrams(strs));
    }
}


