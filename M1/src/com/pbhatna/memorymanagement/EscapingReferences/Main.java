package com.pbhatna.memorymanagement.escapingreferences;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
       Customer cust = new Customer("john");
        String name = cust.getName();
        name = "simon";

        System.out.println(name);
    }

}
