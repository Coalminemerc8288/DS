package com.pbhatna.stringandarrays;

/**
 * Implement pow(x, n).
 */
public class PowerFunction {

    public static double pow(double value, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / pow(value,-n);
        }

        double result = pow(value, n/2);
        System.out.println("result"+ result + "------>value" + n);

        if (n%2 == 0)
            return result * result;
        else
            return value * result * result;
}

    public static void main(String []args) {
        int n = 7;
        double k = 2;
        System.out.println("power of " + n +" for " + k + " is equal "+pow(k,n));
        System.out.println("should be equal to: "+ Math.pow(k,n));
    }

}
