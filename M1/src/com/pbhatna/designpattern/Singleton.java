package com.pbhatna.designpattern;

/**
 * Singleton Pattern: Exactly(at most once instance) of object should be created
 *
 * Scenarios:
 * Multiple instances could be memory expensive operations
 *
 * Basic bare bone implementation
 * Problem: In real life scenario, Using synchronized keyword is quite a performance hit
 * Solution:
 *         1) Eagerly instantiate the singleton(no need to synchronize the getter after that)
 *         2) Double checking locking (Also mark the member variable volatile)
 */
public class Singleton {

    // we maintain one private static instance
    private static Singleton singleton;                     // Rule No.1

    private Singleton() {                                   //Rule No.2
        // private constructor is the key
        // No body can instantiate outside the class
    }

    // The method is marked synchronized for thread safety,
    // else it is possible that 2 different threads might enter
    // this method simultaneously and create more than 1 instance

    public static synchronized Singleton getInstance() {    //Rule No.3
        if (singleton == null) {
            // first time when someone ask for the singleton
            // this will be instantiated- this is the first and last time,
            // code will execute
            singleton = new Singleton();
        }
        return singleton;
    }
}
