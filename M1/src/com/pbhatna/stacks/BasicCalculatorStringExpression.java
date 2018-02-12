package com.pbhatna.stacks;
import java.util.Stack;


/**
 * Difficulty: Hard
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 *  Some examples:
 *  "1 + 1" = 2
 *  " 2-1 + 2 " = 3
 *  "(1+(4+5+2)-3)+(6+8)" = 23
 *
 *  Solution Idea: Stack can be used and when we encounter ")" we calculate the sum else keep pushing the elements on to the stack
 *  Only 5 possible input can be there
 *      1) digit: it should be one digit from the current number
 *      2) ‘+’: number is over, we can add the previous number and start a new number
 *      3) ‘-’: same as above
 *      4) ‘(’: push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
 *      5) ‘)’: pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
 *      second is the temporary result before this pair of parenthesis. We add them together.
 */
public class BasicCalculatorStringExpression {

    public static void main(String args[]) {
       System.out.println((int) 'H');
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        // To store basic info
        int result = 0;
        int sign = 1;    // will store -1 or 1
        int carry = 0;  // carry

        // Iterate over string
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
                if (Character.isDigit(c)) {
                  carry = 10 * carry + (int) (c - '0'); // subtracting char takes an ascii, cast the value in int
                } else if (c == '+') {
                    result += sign * carry;
                    carry = 0;         //reset
                    sign  = 1;
                } else if (c == '-') {
                    result += sign * carry;
                    carry = 0;         //reset
                    sign = -1;
                } else if (c == '(') {
                    // push result first and then sign
                    stack.push(result);
                    stack.push(sign);
                    // result sign and result
                    sign = 1;
                    result = 0;
                } else if (c == ')') {
                    result += sign * carry;
                    carry = 0;   //reset

                    result *= stack.pop();   //sign before the parenthesis
                    result += stack.pop();  //result calculated before parenthesis
                }

                //Make sure no carry is remaining
                if (carry !=0) {
                    result += sign * carry;
                }
                return result;
        }
        return result;
    }
}
