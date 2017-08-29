package com.pbhatna.searchingsorting;

/**
 * Insertion sort start with smaller sorted sub list and grows from left to right.
 * Its indeed better than bubble sort for variety of reasons
 *  1) Bubble sort takes additional pass to ensure list is sorted
 *  2) Bubble sort has to do N comparisons at every step. Insertion sort stop comparisons when list is sorted
 *  in each iteration
 *  3) Bubble sort performs poorly with number of swaps it performs on the modern hardware
 *
 * Time Complexity: O(n^2)
 * Stable: Equal elements might be rearranged after the sort
 * Adaptive: which is break early if list is sorted
 * Space: O(1) constant space (In place operation)
 *
 * Comparisons: O(n^2) comparisons and O(n^2) swaps
 */
public class InsertionSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        insertionSort(listToSort);
    }

    public static void insertionSort(int [] listToSort) {
        for (int i = 0; i < listToSort.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j-1]) {
                    swap(listToSort, j, j-1);
                } else {
                    break;
                }
            }
            print(listToSort);
        }
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

}
