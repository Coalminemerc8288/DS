package com.pbhatna.binaryheap;

/**
 * Find minimum element in the max heap, find the last index in the max heap and find the last parent,
 * iterate through all the child leaf elements to find the min value
 */
public class FindMinElementInMaxHeap {

    public static int getMinimum(MaxHeap<Integer> maxHeap) {
        int lastIndex = maxHeap.getCount() - 1;
        int parentIndex = maxHeap.getParentIndex(lastIndex);

        int firstChildIndex = parentIndex + 1;
        int minElement = maxHeap.getElementAtIndex(firstChildIndex);
        for (int i = firstChildIndex; i <lastIndex; i++ ) {
            if (maxHeap.getElementAtIndex(i) < minElement) {
                minElement = maxHeap.getElementAtIndex(i);
            }
        }
        return minElement;
    }

    public static void main(String[] args) throws Heap.HeapOverflowException, Heap.HeapUnderflowException {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);
        maxHeap.insert(9);
        maxHeap.insert(4);
        maxHeap.insert(17);
        maxHeap.insert(6);
        maxHeap.insert(100);
        maxHeap.insert(20);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(3);

        maxHeap.printHeapArray();

        System.out.println("Minimum Element in max heap:"+getMinimum(maxHeap));
    }
}
