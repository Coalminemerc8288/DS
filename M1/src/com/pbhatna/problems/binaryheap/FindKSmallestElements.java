package com.pbhatna.problems.binaryheap;

/**
 * Find K smallest elements
 */
public class FindKSmallestElements {
    public static MaxHeap<Integer> findkSmallestElement(int[] array, int k) throws Heap.HeapOverflowException, Heap.HeapUnderflowException {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class, k);

        for (int num: array) {
            if (maxHeap.isEmpty()) {
                maxHeap.insert(num);
            } else if (!maxHeap.isFull() || (int) maxHeap.getHighestPriority() > num) {
                if (maxHeap.isFull()) {
                    maxHeap.removeHighestPriority();
                }
                maxHeap.insert(num);
            }
        }
        return maxHeap;
    }

    public static void main (String [] args) {
        int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};
        try {
            MaxHeap<Integer> maxHeap = findkSmallestElement(randomNumberArray, 6);
            maxHeap.printHeapArray();


            maxHeap = findkSmallestElement(randomNumberArray, 8);
            maxHeap.printHeapArray();

            maxHeap = findkSmallestElement(randomNumberArray, 12);
            maxHeap.printHeapArray();

        } catch (Heap.HeapUnderflowException | Heap.HeapOverflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
