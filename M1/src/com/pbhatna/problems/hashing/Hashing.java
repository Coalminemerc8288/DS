package com.pbhatna.problems.hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Hash Function
 *
 * Contract Hash Code: If two objects are equal then calling hashCode() on both elements
 * must return the same value
 *
 */
public class Hashing {

    public static void main(String[] args) {
        // create map
        Map<String, String> map = new HashMap<String,String>();

        // populate the map
        map.put("1","ALIVE ");
        map.put("2","IS");
        map.put("3","AWESOME");

        // create a synchronized map
        Map<String,String> syncMap = Collections.synchronizedMap(map);

        System.out.println("Synchronized map :"+syncMap);
    }
}
