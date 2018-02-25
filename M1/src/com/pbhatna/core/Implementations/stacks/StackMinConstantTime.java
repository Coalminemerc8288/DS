package com.pbhatna.core.Implementations.stacks;

/**
 * Find Stack minimum in constant time with help of two stacks
 */
public class StackMinConstantTime {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int data)
            throws Stack.StackOverflowException,
            Stack.StackUnderflowException {
        int min = data;
        if (!minStack.isEmpty()) {
            if (min > minStack.peek()) {
                min = minStack.peek();
            }
            stack.push(data);
            minStack.push(min);
        }
    }

    public int pop() throws Stack.StackUnderflowException {
        minStack.pop();
        return stack.pop();
    }

    public int getMinimum()  throws Stack.StackUnderflowException {
        return minStack.peek();
    }
}
