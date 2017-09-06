package com.pbhatna.stacks;

import java.lang.reflect.Array;
/**
 * Section 3(leetcode): Implement stack using array
 *
 * Main methods:
 * push
 * pop
 * peek
 *
 * Time Complexity: O(1)
 *
 */
public class Stack<T extends Comparable<T>> {

    private static int MAX_SIZE = 40;
    private T [] array;
    private int count;

    public Stack(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Stack(Class<T> clazz, int size) {
        this.count = 0;
        this.array = (T[]) Array.newInstance(clazz, size);
    }

    public void push(T data) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        array[count] = data;
        count++;
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T element = array[count-1];
        count--;
        return element;
    }

    public T peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }

        return this.array[count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count > 0 && count == MAX_SIZE;
    }

    public int getSize() {
        return this.count;
    }

    public static class StackOverflowException extends Exception {}

    public static class StackUnderflowException extends Exception {}

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        MAX_SIZE = 4;
        Stack<Integer> stack = new Stack<>(Integer.class, MAX_SIZE);

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
