package com.pbhatna.threads;

import static com.pbhatna.threads.ThreadColor.ANSI_BLUE;
/**
 *  Thread 2
 */
public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread wake me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I am awake:");
    }
}
