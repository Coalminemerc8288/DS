package com.pbhatna.problems.advanced.recursion;

public class HouseBuildingProblem {
    /**
     * Tail recursion is very similar to iterative approach
     * Ex For or while loop
     * @param height
     */
    public static void buildLayers(int height) {
        if (height == 0) { return;}

        System.out.println("Height"+ height);

        buildLayers(height-1);
    }

    public static void main(String [] args) {
        buildLayers(4);
    }
}
