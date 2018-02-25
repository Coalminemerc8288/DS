package com.pbhatna.core.Implementations.queue;

import com.pbhatna.core.Implementations.stacks.Stack;

public class QueueWIthTwoStacks<T> {
    private Stack<T> forwardStack = new Stack<>();
    private Stack<T> reverseStack = new Stack<>();

    public QueueWIthTwoStacks() {}

    public void enqueue(T data) throws Queue.QueueOverflowException {
        if (isFull()) {
            throw new Queue.QueueOverflowException();
        }
        try {
            if (forwardStack.isEmpty()) {
                while (!reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch(Stack.StackOverflowException | Stack.StackUnderflowException e) {
            throw new Queue.QueueOverflowException();
        }
    }

    public T dequeue() throws Queue.QueueUnderflowException {
        if (isEmpty()) {
            throw new Queue.QueueUnderflowException();
        }
        try {
            if (reverseStack.isEmpty()) {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException e) {
            throw new Queue.QueueUnderflowException();
        }
    }

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }
}
