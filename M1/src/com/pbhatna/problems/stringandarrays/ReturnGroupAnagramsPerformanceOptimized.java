package com.pbhatna.problems.stringandarrays;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Using sorting is not et all performance optimized,
 * so better strategy is to use counter and generate customized hash
 * to track the strings
 */
public class ReturnGroupAnagramsPerformanceOptimized {

    public static List<List<String>> getGroupAnagrams(String [] strs) {

        if (strs == null || strs.length == 0) {
            new ArrayList<List<String>>(0);
        }

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {

            // Only lower-case letters. so array of size 26 is enough
            int[] counter = new int [26];

            // Iterate through each string and increment the index of
            // char-'a', so index will be between 0 to 25
            for (int j=0; j <str.length(); j++) {
                counter[str.charAt(j)-'a'] ++;
            }

            // Now iterate through the counter array to build the hash
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<26; j++){
                if(counter[j] > 0) {
                    sb.append(counter[j]);
                    sb.append((char) ('a'+ j));
                }
            }

            String key = sb.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());

            //Add this string to the list pointed by hash
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String [] strs = {"eat","tea", "tan", "ate","nat","bat"};
        System.out.println("--->"+ getGroupAnagrams(strs));
    }
}
