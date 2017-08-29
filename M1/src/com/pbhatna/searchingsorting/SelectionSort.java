package com.pbhatna.searchingsorting;

/**
 * Selection sort, most naive sort and never used anywhere
 *
 * Time Complexity: O(n^2)
 * Not Stable: Equal elements might be rearranged after the sort
 * Not Adaptive: which is break early if list is sorted
 * Space: O(1) constant space (In place operation)
 *
 * Comparisons: O(n^2) comparisons and O(n) swaps
 */
public class SelectionSort {


    private static int listToSort[] = new int[] {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

    public static void main(String[] args) {
        print(listToSort);
        selectionSort(listToSort);
    }

    public static void selectionSort(int [] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i+1; j <listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    swap(listToSort, i, j);
                }
            }
        }
        print(listToSort);
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
