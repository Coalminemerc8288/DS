package com.pbhatna.problems.queue.priorityqueue;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 *
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 *
 * Todo: @redo
 */
public class SmallestRange {

    public int[] getSmallestRange(int [][] nums) {

        // Priority Queue, int[] replaces an element node(not required in this scenario)
        Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(i, 0, nums[i][0]);  //   value, index, row
            minHeap.add(node);
            max = Math.max(max, nums[i][0]);
        }

        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        while (minHeap.size() == nums.length) {

            // Pop smallest element
            Node curr = minHeap.poll();

            // Find or Update start, end and range
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }

            // add the next element of the array to the heap
            if (curr.index + 1 < nums[curr.row].length) {
                curr.index = curr.index + 1;
                curr.val = nums[curr.row][curr.index];
                minHeap.add(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }
        return new int[] {start, end};
    }

    class Node {
        int val;
        int index;
        int row;

        public Node(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }
}
