package com.pbhatna.binaryheap;


import com.pbhatna.tree.printer.BTreePrinter;

/**
 * Min Heap
 *
 * Binary heap that has minimum value with the highest priority and exist at the root.
 * Parent value is smaller than its child elements
 */
public class MinHeap<T extends Comparable<T>> extends Heap {
    public MinHeap(Class clazz) {
        super(clazz);
    }

    public MinHeap(Class clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    @Override
    protected void siftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        // Find the minimum of the left and right child elements
        int smallestIndex = -1;
        if (leftChildIndex != -1 && rightChildIndex != -1) {
            smallestIndex =  getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) < 0 ? leftChildIndex : rightChildIndex;
        } else if (rightChildIndex == -1) {
            smallestIndex = leftChildIndex;
        } else if (leftChildIndex == -1) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex == -1) {
            return;
        }

        // Compare the smaller child with the current index to see if a swap
        // and further sift down is needed.
        if (getElementAtIndex(smallestIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallestIndex, index);
            siftDown(smallestIndex);
        }
    }

    public static void main(String[] args) throws HeapOverflowException, HeapUnderflowException {

        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();

        minHeap.insert(6);
        minHeap.printHeapArray();

        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.printHeapArray();

        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
    }
}