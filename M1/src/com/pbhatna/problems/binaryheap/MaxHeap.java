package com.pbhatna.problems.binaryheap;

/**
 * (Max Heap)
 * Binary heap that has maximum value with the highest priority and exist at the root.
 * Parent value is larger than its child elements
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(Class<T> clazz) {
        super(clazz);
    }

    public MaxHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int largestIndex = -1;
        if (leftChildIndex != -1 && rightChildIndex != -1) {
            largestIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) > 0 ? leftChildIndex: rightChildIndex;
        } else if (leftChildIndex == -1) {
            largestIndex = rightChildIndex;
        } else if (rightChildIndex == -1) {
            largestIndex = leftChildIndex;
        }

        if (largestIndex == -1) {
            return;
        }

        // Compare the larger child with the current index to see if a swap
        // and further sift down is needed.
        if (getElementAtIndex(largestIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(largestIndex, index);
            siftDown(largestIndex);
        }
    }

    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    public static void main(String[] args) throws HeapOverflowException, HeapUnderflowException {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);
        maxHeap.insert(9);
        maxHeap.insert(4);
        maxHeap.insert(17);
        maxHeap.printHeapArray();

        maxHeap.insert(6);
        maxHeap.printHeapArray();

        maxHeap.insert(100);
        maxHeap.insert(20);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.printHeapArray();

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.printHeapArray();

        maxHeap.removeHighestPriority();
        maxHeap.printHeapArray();

        maxHeap.removeHighestPriority();
        maxHeap.printHeapArray();
    }
}