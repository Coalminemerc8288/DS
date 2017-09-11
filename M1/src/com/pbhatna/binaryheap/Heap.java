package com.pbhatna.binaryheap;
import java.lang.reflect.Array;

/**
 * Priority Queue (Binary Heap Implementation)
 *
 *  Time Complexity with array implementation(parent, left child, right child)
 *  Insertion - O(log n)
 *  Removal - O(log n)
 *  Access - O(1)
 */
public abstract class Heap<T extends Comparable<T>> {
    private static final int MAX_SIZE = 40;
    private T[] array;
    private int count;

    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE );
    }

    public Heap(Class<T> clazz, int size) {
        array =(T []) Array.newInstance(clazz, size);
    }

    /**
     * Get highest priority element without removing it
     */
    public T getHighestPriority() throws HeapUnderflowException {
        if (isEmpty()) {
            throw new HeapUnderflowException();
        }
        return array[0];
    }

    /**
     * Insert new element to the correct spot in the binary heap
     */
    public void insert(T value)  throws HeapOverflowException {
        if (isFull()) {
            throw new HeapOverflowException();
        }

        array[count] = value;
        siftUp(count);             // move new element in the correct position respect to element before
        count ++;
    }

    /**
     * Remove highest priority element from the binary heap and balance the heap using siftdown operation
     * once the element is removed
     */
    public T removeHighestPriority() throws HeapUnderflowException {
        if (isEmpty()) {
            throw new HeapUnderflowException();
        }
        T element = getHighestPriority();
        array[0] = array[count-1];
        siftDown(0);
        count --;
        return element;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > array.length) {
            return -1;
        }
        return (index - 1) /2;
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count) {
            return - 1;
        }
        return rightChildIndex;
    }

    // Helper Functions
    protected void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count >= array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    protected abstract void siftUp(int index);

    protected abstract void siftDown(int index);

    public static class HeapOverflowException extends Exception {}

    public static class HeapUnderflowException extends Exception {}

    public void printHeapArray() {
        for (int i = 0 ; i < count; i++ ) {
            System.out.println(array[i]);
        }
        System.out.println();
        try {
            System.out.println("Get highest priority element: "+ getHighestPriority());
        } catch (HeapUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
