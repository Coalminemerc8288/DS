package com.pbhatna.stringandarrays;

/**
 * Implement pow(x, n).
 */
public class PowerFunction {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }

        double result = myPow(x, n/2);

        if (n%2 == 0)
            return result * result;
        else
            return x * result * result;
    }

    public static void main(String []args) {
        int n = -2147483648;
        double k = 2;
        System.out.println("power of " + n +" for " + k + " is equal "+ myPow(k,n));
        System.out.println("should be equal to: "+ Math.pow(k,n));
    }
}
