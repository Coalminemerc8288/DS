package com.pbhatna.problems.queue;
import java.lang.reflect.Array;

/**
 * Circular Array Implementation of queue
 */
public class Queue<T extends Comparable<T>> {

    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static final int MAX_SIZE = 40;

    private T[] elements;

    private int headIndex = -1;
    private int tailIndex = -1;

    public Queue(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Queue(Class<T> clazz, int size) {
        elements = (T []) Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex +1) % elements.length;
        elements[tailIndex] = data;

        // if this is the first element enqueued so set the head equal to the tail
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public boolean offer(T data) {
        if (isFull()) {
            return false;
        }
        try {
            enqueue(data);
        } catch(QueueOverflowException e) {
            // Do nothing
        }
        return true;
    }


    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T data  = elements[headIndex];

        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return elements[headIndex];
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }

    public static class QueueOverflowException extends Exception {}

    public static class QueueUnderflowException extends Exception {}


    public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException{
        Queue<Integer> queue = new Queue<>(Integer.class);

        System.out.println("queue full?: " + queue.isFull());
        System.out.println("queue empty?: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("queue peek: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Peek : " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Peek : " + queue.peek());

        try {
            queue.enqueue(5);
            queue.enqueue(6);
        } catch (QueueOverflowException soe) {
            System.out.println("queue is full! No room available.");
        }

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("queue peek: " + queue.peek());
    }
}