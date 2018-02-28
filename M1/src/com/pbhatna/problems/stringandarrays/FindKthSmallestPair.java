package com.pbhatna.problems.stringandarrays;
import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 *  Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *  Example 1:
 *  Input:
 *  nums = [1,3,1]
 *  k = 1
 *  Output: 0
 *
 *  Explanation:
 *  Here are all the pairs:
 *  (1,3) -> 2
 *  (1,1) -> 0
 *  (3,1) -> 2
 *  Then the 1st smallest distance pair is (1,1), and its distance is 0.
 *
 *  @RevisitAgain
 */
public class FindKthSmallestPair {

    public int smallestDistancePair(int []a, int k) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;

        // find min
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
        }

        // find max
        int max = a[a.length - 1] - a[0];

        // Binary search for kth absolute difference
        while (min < max) {
            int mid = min + (max - min)/2;
            if (countPairs(a, mid) < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    public int countPairs(int[] a, int mid) {
        int result = 0;
        for (int i = 0; i < a.length; i ++) {
            int j = i;          // increment inner pointer and compare a[i] and a[j]
            while (j < a.length && a[j] - a[i] <= mid) {
                result = result +  j - i - 1;
                j++;
            }
        }
        return result;
    }
}
