package com.pbhatna.stacks;

/**
 * Section 3(leetcode): Implement stack using linked list this time
 *
 * Main methods:
 * push
 * pop
 * peek
 *
 * Time Complexity: O(1)
 *
 */
public class StackLinkedListImpl<T extends Comparable<T>> {
    private static int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;

    public void push(T data) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }

        Element element = new Element(data, top);
        top = element;
        size++;
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T element = top.getData();
        top = top.getNext();
        size--;
        return element;
    }

    public T peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return top.getData();
    }

    public boolean isFull() {
        return this.size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
       return this.size;
    }

    public static class StackOverflowException extends Exception {}

    public static class StackUnderflowException extends Exception {}

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        MAX_SIZE = 4;
        StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Stack full?: " + stack.isFull());
        System.out.println("Stack empty?: " + stack.isEmpty());

        stack.push(4);
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Stack full?: " + stack.isFull());
        System.out.println("Stack empty?: " + stack.isEmpty());

        System.out.println("Stack peek: " + stack.peek());

        int data = stack.pop();
        System.out.println("Popped element: " + data);

        System.out.println("Peek again: " + stack.peek());

        try {
            stack.push(4);
            stack.push(5);
        } catch (StackOverflowException soe) {
            System.out.println("Stack is full! No room available.");
        }

        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (StackUnderflowException sue) {
            System.out.println("Stack is empty! No elements available.");
        }
    }
}
