package com.pbhatna.problems.stringandarrays;
import java.util.List;

/**
 * 539. Minimum Time Difference
 *Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 *
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 * Solution: Store Time data points. There is only 24 * 60 = 1440 possibilities.
 * Create a boolean array to see if time point exists or not
 *
 */
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean [] marked = new boolean[1440];
        for (String time: timePoints) {
            String [] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);

            if (marked[h * 60 + m]) { return 0; }

            marked[h * 60 + m] = true;
        }

        int prev = 0;
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;

        for (int i =0; i < 24 * 60; i ++) {
            if (marked[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }

                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        min = Math.min(min, (24 * 60 - last + first));
        return min;
    }
}
