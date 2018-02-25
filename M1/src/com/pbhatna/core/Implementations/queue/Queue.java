package com.pbhatna.core.Implementations.queue;

import java.lang.reflect.Array;

public class Queue<T> {

    private static final int  SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public Queue(Class<T> clazz, int size) {
        elements = (T[]) Array.newInstance(clazz, size);
    }

    public Queue(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        //If this is the first element enqueued, then increment the head index
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public boolean Offer(T data) {
        if (isFull()) {
           return false;
        }
        try {
            enqueue(data);
        } catch (QueueOverflowException e) {
            // ignore
        }
        return true;
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T data = elements[tailIndex];

        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public T peek()  throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return elements[headIndex];
    }

    public boolean isEmpty () {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }


    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }

    public static class QueueOverflowException extends Exception {}

    public static class QueueUnderflowException extends Exception {}

}
