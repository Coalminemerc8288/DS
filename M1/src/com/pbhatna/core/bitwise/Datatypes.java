package com.pbhatna.core.bitwise;

public class Datatypes {

    public static void main(String [] args) {

        // Integer Category
        // byte     size:8      range:  (2 ^8) -1
        // short    size:16     range:  (2 ^16) -1
        // int      size:32     range:  (2 ^32) -1
        // long     size:64     range:  (2 ^64) -1

        System.out.println("Min value: "+ ((byte) -Math.pow(2,7)) +" Max value: "+ ((byte) Math.pow(2,7) + 1));
        System.out.println("Min value: "+ ((short)-Math.pow(2,15)) +" Max value: "+ ((short) Math.pow(2,15) + 1));
        System.out.println("Min value: "+ ((int)-Math.pow(2,31)) +" Max value: "+ ((int)Math.pow(2,31) + 1));
        System.out.println("Min value: "+ ((long)-Math.pow(2,63)) +" Max value: "+ ((long)Math.pow(2,63) + 1));

        // Float Category
        // Float     size: 32     range:  (2 ^32) -1
        // Double    size: 64     range:  (2 ^64) -1
        System.out.println("Min value: "+ ((float) -Math.pow(2,31)) +" Max value: "+ ((float) Math.pow(2,31) + 1));
        System.out.println("Min value: "+ (-Math.pow(2,63)) +" Max value: "+ (Math.pow(2,63) + 1));

        // Boolean only true or false

        // Char
        System.out.println("Min value: "+ '\u0000' +" Max value: "+Character.MIN_VALUE);

        char char1 = 50;
        System.out.println('a' + 'b');

    }
}
