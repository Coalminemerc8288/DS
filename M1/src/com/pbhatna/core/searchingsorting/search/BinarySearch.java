package com.pbhatna.core.searchingsorting.search;

/**
 * Binary Search
 *
 * Run time complexity: O(log n)
 */
public class BinarySearch {

    public static int[] sortedArray = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};

    public static int binarySearch(int [] sortedArray, int num, int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = min + (max-min) / 2;
        if (sortedArray[mid] == num) {
            return mid;
        }

        if (sortedArray[mid] > num) {
            max = mid-1;
            return binarySearch(sortedArray, num, min, max);
        } else {
            min = mid + 1;
            return binarySearch(sortedArray, num, min, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("%s is present at index: %s",
                30, binarySearch(sortedArray, 30, 0, sortedArray.length - 1)));
        System.out.println(String.format("%s is present at index: %s",
                4, binarySearch(sortedArray, 4, 0, sortedArray.length - 1)));
        System.out.println(String.format("%s is present at index: %s",
                15, binarySearch(sortedArray, 15, 0, sortedArray.length - 1)));
    }
}
