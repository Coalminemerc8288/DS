package com.pbhatna.memorymanagement.bookcatalog;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        BookCollection bc = new BookCollection();

        bc.printAllBooks();

        //get price of book called Tom Jones in EUR
        System.out.println(bc.findBookByName("Tom Jones").getPrice().convert("EUR"));

        System.out.println("---------");

        bc.printAllBooks();

    }
}
