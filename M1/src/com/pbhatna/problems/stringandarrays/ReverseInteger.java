package com.pbhatna.problems.stringandarrays;

/**
 * Reverse integer principle
 *
 *  Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
 *  Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50
 *  Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7
 */
public class ReverseInteger {

    public static int getReverse(int num) {
        int resultNumber = 0;
        while (num != 0) {
            resultNumber = resultNumber * 10 + num % 10;
            num /= 10;
        }
        return resultNumber;
    }

    public static void main(String [] args) {
        int k = 12345;
        System.out.println("Reverse of:" + k +" is "+ getReverse(k));
    }
}
