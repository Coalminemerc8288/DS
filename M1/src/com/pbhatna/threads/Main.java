package com.pbhatna.threads;
import static com.pbhatna.threads.ThreadColor.ANSI_PURPLE;
import static com.pbhatna.threads.ThreadColor.ANSI_GREEN;
import static com.pbhatna.threads.ThreadColor.ANSI_RED;

/**
 * Threads and Concurrency
 */
public class Main {

    public static void main (String [] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        // 1
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        //2
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN +"Anonymous class");
            }
        }.start();
        //3
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "Another Thread terminated or timed out, so I am running again");
                } catch(InterruptedException e) {
                    System.out.println(ANSI_RED +"I couldn't wait after all I was interrupted");
                }

            }
        });

        myRunnableThread.start();

        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from same thread");
    }
}
