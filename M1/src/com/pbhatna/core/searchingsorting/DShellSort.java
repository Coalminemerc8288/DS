package com.pbhatna.core.searchingsorting;

/**
 * Shell sort uses insertion sort at its core
 *
 * Shell sort partitions the unsorted list into sub list which is made by elements
 * seperated by the increment.
 *
 * Shell sort work on each sub list and reduce increment in each iteration.
 * Over All time complexity better than insertion sort
 *
 *
 * Time Complexity: Between O(n) to O(n)^2. Exact time complexity can't be calculated but better than insertion sort
 * because last iteration works on nearly sorted list
 *
 * Stable: Equal elements will maintains the order as before
 * Adaptive: which is break early if list is sorted
 * Space: O(1) constant space (In place operation)
 *
 * Comparisons: O(n^2) comparisons and O(n) swaps
 */
public class DShellSort {

    private static int listToSort[] = new int[]{3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        shellSort(listToSort);
    }

    public static void shellSort(int []listToSort) {
        int increment = listToSort.length / 2;

        while(increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment);
            }
           increment = increment / 2 ;
        }
    }

    public static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i = i + increment) {
            for (int j = Math.min(i+ increment, listToSort.length-1); j-increment >=0; j = j-increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    swap(listToSort, j, j - increment);
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
