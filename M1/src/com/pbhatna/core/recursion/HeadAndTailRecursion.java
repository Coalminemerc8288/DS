package com.pbhatna.core.recursion;
/**
 * Head and Tail Recursion
 */
public class HeadAndTailRecursion {
    /**
     * If recursion happens at the end of the method(after method logic), its called
     * tail recursion
     *
     */
    public static void tail(int N) {
        if (N == 1) {return;}

        System.out.println("Tail Recursion: " + N);

        tail(N-1);
    }

    /**
     * If recursion happens at the beginning of the method(before method logic), its called
     * head recursion
     *
     * Note: Head recursion uses a operating system's stack memory
     * to store the references for method call and parameters arguments
     */
    public static void head(int N) {
        if (N == 1) {return;}

        head(N-1);

        System.out.println("Head Recursion: "+N);
    }

    public static void main(String [] args) {
       tail(5);

       System.out.println();

       head(5);
    }
}
