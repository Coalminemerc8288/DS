package com.pbhatna.problems.stringandarrays;

import java.util.*;

/**
 * ReturnAllAnagramsForString
 *
 * Performance: It currently uses sort which would be O(nlogn), which could be improved
 * Assumption map is provided
 */
public class ReturnAllAnagramsForString {

    public static ArrayList<String> getGroupAnagrams(Map<String, List<String>> map, String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>(0);
        }

        char[] ca = str.toCharArray();
        Arrays.sort(ca);

        String key = String.valueOf(ca);
        if (map.containsKey(key)) {
           return new ArrayList<>(map.get(key));
        } else {
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        String str = "aet";
        Map<String, List<String>> map = new HashMap<>();
        ArrayList<String> as = new ArrayList<>();
        as.add("eat");
        as.add("tea");
        as.add("ate");

        map.put(str, as);
        System.out.println("--->"+ getGroupAnagrams(map, str));
    }
}
