package com.pbhatna.stringandarrays;

/**
 * Implement power function pow(x, n) where x could be double and n is integer
 */
public class PowerFunction {

    public static double pow(double value, int n) {

        // case1
        if (n == 0) {
            return 1;
        }

        // case 2
        if (n < 0) {
            return 1/pow(value, -n);
        }

        // recursive call
        double temp = pow(value, n/2);
        System.out.println("temp----->"+temp + "-----n----->" + n);

        if (n%2 == 0) {
            return temp * temp;
        } else {
            return value * temp * temp;
        }
    }

    public static void main(String [] args) {
        System.out.println(Math.pow(2, 8) + " is equal to " + pow(2, 8));
    }
}
