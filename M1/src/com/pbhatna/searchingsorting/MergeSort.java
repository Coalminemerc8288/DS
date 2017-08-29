package com.pbhatna.searchingsorting;

/**
 * Merge sort is a popular sort, use divide and concur approach.
 *
 * Divided into three parts: 1) Split the list and 2) merge the list(During merging sorting takes place)
 * 3) merge sort
 *
 *
 * Time Complexity: O(n log n)
 * Stable: Equal elements might be rearranged after the sort
 * Adaptive: which is break early if list is sorted
 * Space: O(n) extra space
 *
 */
public class MergeSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        mergeSort(listToSort);
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void mergeSort(int[] listToSort) {

        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length /2 + listToSort.length % 2;
        int [] listFirstHalf = new int[midIndex];
        int [] listSecondHalf = new int[listToSort.length - midIndex];
        split(listToSort, listFirstHalf, listSecondHalf);

        print(listFirstHalf);
        print(listSecondHalf);

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);
        print(listToSort);
    }

    public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int secondHalfIndex = listFirstHalf.length;
        while (index < listToSort.length) {
            if (index < secondHalfIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - secondHalfIndex] = listToSort[index];
            }
            index++;
        }
    }

    public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < listFirstHalf.length) {
            while(mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }

        if (secondHalfIndex < listSecondHalf.length) {
            while(mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
            }
        }
    }

}
