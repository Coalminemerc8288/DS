package com.pbhatna.binaryheap;

/**
 * Find K Largest elements
 */
public class FindKLargestElements {

    public static MinHeap<Integer> findKLargestElements(int [] array, int k)
            throws Heap.HeapUnderflowException, Heap.HeapOverflowException {

        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);
        for (int num : array) {
            if (minHeap.isEmpty()) {
                minHeap.insert(num);
            } else if (!minHeap.isFull() || (int) minHeap.getHighestPriority() < num) {
                if (minHeap.isFull()) {
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(num);
            }
        }

        return minHeap;
    }

    public static void main (String args[]) {

        int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};
        try {
            MinHeap<Integer> minHeap = findKLargestElements(randomNumberArray, 6);
            minHeap.printHeapArray();


            minHeap = findKLargestElements(randomNumberArray, 8);
            minHeap.printHeapArray();

            minHeap = findKLargestElements(randomNumberArray, 12);
            minHeap.printHeapArray();

        } catch (Heap.HeapUnderflowException | Heap.HeapOverflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
