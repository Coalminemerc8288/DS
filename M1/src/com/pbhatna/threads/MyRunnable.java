package com.pbhatna.threads;
import static com.pbhatna.threads.ThreadColor.ANSI_RED;
/**
 * MyRunnable
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from my runnable implementation");
    }
}
