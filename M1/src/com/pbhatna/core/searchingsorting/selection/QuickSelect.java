package com.pbhatna.core.searchingsorting.selection;

import java.util.Random;

/**
 * "Hoare Algorithm"- same person who constructed quick sort
 *
 * Best/Average: O(N)
 * Worst: O(n^2)
 *
 * To find the kth smallest/ largest element in an un ordered array with liner average time O(n) running time
 * complexity.
 *
 * AIM: Aim is to find the item with O(n) linear time complexity with no extra space.
 *
 * Binary Heap is a good option with O(log) to insert and remove element but requires additional
 * space. That's why quick select is better option if there is a memory restrictions.
 *
 * All the sorting algorithms has the O(n^2) running time and the best ones O(n log n).
 *
 * For example Maximum, Minimum, Median or Second Max, Second Min etc
 *
 *  @Advantages over priority queue
 *  1. No extra space
 *  @DisAdvantages over priority queue
 *  1. Little bit slower O(n) linear time complexity
 */
public class QuickSelect {
    /**
     * Concept: 1) partition 2) select
     * 1. Choose the pivot at random and partition the array
     * 2. Instead of recursing in both the sides, will pick only one side
     */
    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k) {
        return select(0, nums.length-1, k-1);
    }

    private int select(int firstIndex, int lastIndex, int k) {
        int pivot = partition(firstIndex, lastIndex);

        if (pivot > k) {
            select(firstIndex, pivot-1, k);
        } else if (pivot < k) {
            select(pivot+1, lastIndex, k);
        }
        return nums[k];
    }

    /**
     * Partition: Slight trick to reverse the direction of element
     * Use "<" to sort the array to get smallest item
     * Use ">" to sort the array in reverse to get largest
     */
    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex-firstIndex+1) + firstIndex;       // Pivot between the bound

        swap(lastIndex, pivot);     // Put pivot to the last index position

        for (int i=firstIndex; i < lastIndex; ++i) {
            if (nums[i] > nums[lastIndex]) {    // Compare each element to the last index
                swap(i, firstIndex);            // if ith element greater than last, then swap with firstIndex
                firstIndex++;                   // keep incrementing firstIndex
            }
        }
        swap(firstIndex, lastIndex);    // Bring the pivot back to the approx mid(first index lies in middle somewhere by then)
                                        // With this swap greater elements on the left and smaller on right
        return firstIndex;
    }

    private void swap(int iIndex, int jIndex) {
        int temp = nums[iIndex];
        nums[iIndex] = nums[jIndex];
        nums[jIndex] = temp;
    }

    public static void main(String[]args) {
        int[] nums = {1,5,4,8,-2};
        QuickSelect quickSelect = new QuickSelect(nums);
        System.out.println(quickSelect.select(2));
    }
}
