package com.pbhatna.core.searchingsorting;

/**
 * Quick sort is even better than merge sort, use divide and concur approach.
 * Partition is not based on the length of the list instead its based on the pivot in the sub list
 *
 * Pivot Usually starts from the first element in the list and all the element smaller than that element move to
 * the left
 *
 *  Two main pieces
 *  1) Partition method which finds a pivot and move elements before or after pivot
 *  2) Quick sort make recursive call to partition
 *
 *  Average Case Time Complexity: O(n log n)
 *  Not Stable: Equal elements might be rearranged after the sort
 *  Not Adaptive: which is break early if list is sorted
 *  Space: O(Log n) extra space for call stack in recursion
 *
 *  Why preferred over merge sort? Reasons:
 *      1) Reading from cache is much better in quick sort
 *      2) Fewer Constraint's on space quick sort is preferred O(log n) for recursion call stack
 */
public class QuickSort {

    private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};

    public static void main(String[] args) {
        print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
        print(listToSort);
    }

    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex -1);
        quickSort(listToSort, pivotIndex+1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;

        while (l < h) {
            while(listToSort[l] <= pivot && l < h) {
                l++;
            }

            while(listToSort[h] > pivot) {
                h--;
            }

            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);
        System.out.println("\nPivot: " + pivot+"\n");
        print(listToSort);
        return h;
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        System.out.println();
        System.out.println(listToSort[iIndex] +" will be swapped by " + listToSort[jIndex]);
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }
}
