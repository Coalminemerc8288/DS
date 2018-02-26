package com.pbhatna.problems.stringandarrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 239. Sliding Window Maximum
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 *
 * For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Solution/Approach
 ------------------------------------

 At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window.
 This means
 1. If an element in the deque and it is out of i-(k-1), we discard them.
 We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

 2.Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail.
 This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

 3.As a result elements in the deque are ordered in both sequence in array and their value.
 At each step the head of the deque is the max element in [i-(k-1),i]

 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null|| a.length == 0 || k < 0) {
            return new int[0];
        }

        int [] result = new int[a.length-k+1];  //final array with max element from each window
        int resultIndex = 0;

        Deque<Integer> q = new ArrayDeque<>(); // array deque just stores the index of max element
        for (int i = 0; i < a.length; i++) {

            // remove any element out of window index from the head
            while (!q.isEmpty() && q.peek() < i-k+1) {
                q.poll();
            }

            // At this point, only element in the deque exist which is in the window range
            // we discard element from the tail which is less then the first element in window
            // because  a[x] < a[i] has less chance to be the max
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);  // add index to the deck

            if (i >= k-1) { // make sure current index is greater than k-1, to make sure we have first max
                result[resultIndex++] = a[q.peek()];
            }
        }
        return result;
    }

    public static void main(String [] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};

        int [] result = maxSlidingWindow(nums, 3);

        for (int i: result) {
            System.out.println(i);
        }
    }
}
