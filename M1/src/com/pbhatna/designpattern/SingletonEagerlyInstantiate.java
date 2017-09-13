package com.pbhatna.designpattern;

/**
 * SingletonEagerlyInstantiate
 */
public class SingletonEagerlyInstantiate {


    // we maintain one private static instance
    private volatile static SingletonEagerlyInstantiate singleton = new SingletonEagerlyInstantiate();

    private SingletonEagerlyInstantiate() {
        // private constructor is the key
        // No body can instantiate outside the class
    }

    // No need for synchronized
    public static SingletonEagerlyInstantiate getInstance() {
        return singleton;
    }
}
