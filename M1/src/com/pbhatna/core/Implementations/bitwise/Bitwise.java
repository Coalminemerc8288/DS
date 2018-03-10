package com.pbhatna.core.Implementations.bitwise;

/**
 *         Decimal	Hexadecimal	        Binary
 *         0	        0	            0000
 *         1	        1	            0001
 *         2	        2	            0010
 *         3	        3	            0011
 *         4	        4	            0100
 *         5	        5	            0101
 *
 */
public class Bitwise {

    public static void main(String[]args) {

        int x = 1;
        int y = 3;

        // Bitwise And ---> "&"
        System.out.println("x & y : "+ (x & y));

        // Bitwise OR ---> "|"
        System.out.println("x | y : "+ (x | y));

        // Bitwise XOR ---> "^"
        System.out.println("x ^ y : "+ (x ^ y));

        // Bitwise NOT ---> "~"
        System.out.println("~(x & y) : "+ ~(x & y));

        char c1 = 'a'; // U+0061 --> 0110 0001
        char c2 = 'b'; // U+0062 --> 0110 0010
        System.out.println("c1 | c2: " + (c1 | c2)); // 0110 0011 --> 99 in decimal

        // bitwise work only on Integer types or boolean and not for any other data types
    }
}
