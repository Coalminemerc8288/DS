package com.pbhatna.problems.stringandarrays;

/**
 * 686. Repeated String Match
 */
public class RepeatedStringMatch {

    public int repeatStringMatch(String A, String B) {
        // Create string builder instance with string A
        StringBuilder sb = new StringBuilder(A);

        int rep = 1;
        while (!sb.toString().contains(B)) {
            sb.append(A);
            rep++;
        }
        return rep;
    }
}
