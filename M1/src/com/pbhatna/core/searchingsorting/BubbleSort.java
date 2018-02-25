package com.pbhatna.core.searchingsorting;

/**
 * Bubble sort, better than selection sort,
 *
 * In each iteration elements compared to the neighbour and swapped if they are not in order
 * end up bubbling the smallest element to the front in each iteration
 *
 * Time Complexity: O(n^2)
 * Stable: Equal elements will maintain the same order as before
 * Adaptive: which is break early if list is sorted
 * Space: O(1) constant space (In place operation)
 *
 * Comparisons: O(n^2) comparisons and O(n^2) swaps
 */
public class BubbleSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        bubbleSort(listToSort);
    }

    public static void bubbleSort(int[] listToSort) {
        for (int i =0; i <listToSort.length; i++) {
        boolean swapped = false;
            for (int j = listToSort.length-1; j > i; j--) {
                if (listToSort[j] < listToSort[j-1]) {
                    swap(listToSort, j, j-1);
                    swapped = true;
                }
            }
            print(listToSort);
            if (!swapped) {
                break;
            }
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
