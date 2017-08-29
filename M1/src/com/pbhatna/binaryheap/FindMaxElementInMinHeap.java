package com.pbhatna.binaryheap;

/**
 * Find Max element in the min heap
 *
 * From the last element find the last parent index, iterate through all the leaf nodes and find maximum
 */
public class FindMaxElementInMinHeap {


    public static int getMaximum(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int parentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = parentIndex + 1;
        int maxElement = (int) minHeap.getElementAtIndex(firstChildIndex);
        for (int i = firstChildIndex; i < minHeap.getCount(); i++) {
            if (minHeap.getElementAtIndex(i).compareTo(maxElement) > 0) {
                maxElement = (int) minHeap.getElementAtIndex(i);
            }
        }
        return maxElement;
    }

    public static void main(String[] args) throws Heap.HeapOverflowException, Heap.HeapUnderflowException {

        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.insert(6);
        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        System.out.println("Maximum Element in min heap:"+getMaximum(minHeap));
    }
}
