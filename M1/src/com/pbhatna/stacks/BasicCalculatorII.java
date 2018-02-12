package com.pbhatna.stacks;
import java.util.Stack;


/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.

 Some examples:
    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5

 * Solution: Same Idea as BasicCalculatorStringExpression
 */
public class BasicCalculatorII {

    public int calculate(String s) {

        if ( s== null || s.length() == 0) { return 0;}

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char  sign = '+';

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            }

            if (sign == '-') {
                stack.push(-num);
            } else if (sign == '+') {
                stack.push(+num);
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
            } else if (sign == '/') {
                stack.push(stack.pop() * num);
            }

            //reset
            num = 0;
        }

        int result = 0;
        for (int i : stack) {
            result += i;
        }

        return result;
    }
}
