package com.pbhatna.designpattern;

/**
 * Created by priyank on 9/13/17.
 */
public class SingletonDoubleCheckingLocking {

    // we maintain one private static instance
    private volatile static SingletonDoubleCheckingLocking singleton;

    private SingletonDoubleCheckingLocking() {
        // private constructor is the key
        // No body can instantiate outside the class
    }

    // Use standard double locking test, so that synchronized penalty
    // is only incurred the first time, when singleton is null.
    // On subsequent test penalty is avoided
    // Volatile keyword prevents any thread from reading cached version and
    // enforces read and write from main memory instead

    public static SingletonDoubleCheckingLocking getInstance() {
        // check 1 of double check lock
        if (singleton == null) {
            synchronized(SingletonDoubleCheckingLocking.class) {
                // check 2 of double check
                if (singleton == null) {
                    singleton = new SingletonDoubleCheckingLocking();
                }
            }
        }
        return singleton;
    }
}
