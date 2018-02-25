package com.pbhatna.problems.queue;

/**
 * queue with the Linked List Implementation
 */
public class QueueLinkedList<T extends Comparable<T>> {


    private Node<T> front = null;
    private Node<T> rear = null;
    private static final int MAX_SIZE = 40;
    private int queueMax;
    private int size;

    public QueueLinkedList() {
        new QueueLinkedList(MAX_SIZE);
    }

    public QueueLinkedList(int size1) {
        front = null;
        rear = null;
        this.size = 0;
        this.queueMax = size1;
        System.out.println(this.queueMax);
    }


    public void enqueue (T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

         Node<T> temp = new Node<T>(data);
        // If queue is empty then both front and rear points to the new node
        if (front == null && rear == null) {
            rear = temp;
            front = rear;
        } else { // else add to the end of queue and front remains unchanged
            rear.setNext(temp);
            rear = temp;
        }
        size ++;
    }

    public T dequeue () throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T data = front.getData();
        front = front.getNext();

        if (front == null) { // back to empty
            front = rear;
        }
        size--;
        return data;
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        return front.getData();
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return this.size == this.MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    public static class QueueOverflowException extends Exception {}

    public static class QueueUnderflowException extends Exception {}



    public void display() {
        if (front == null) {
            System.out.println("Nothing to display:");
        } else {
            int i = 0;
            Node<T> curr = front;
            while (curr != null) {
                System.out.println("Node " + i + " value: "+ curr.getData());
                curr = curr.getNext();
            }
        }
    }

    public static void main(String[] args) {
        try {
            QueueLinkedList<Integer> q = new QueueLinkedList();
            q.enqueue(10);
            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);
            q.dequeue();

            q.dequeue();
            q.dequeue();

            System.out.println("Size: "+ q.getSize());
            System.out.println("Peek"+ q.peek());
            q.display();

        } catch(QueueOverflowException | QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}