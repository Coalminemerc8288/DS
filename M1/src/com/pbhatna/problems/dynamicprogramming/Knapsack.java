package com.pbhatna.problems.dynamicprogramming;

/**
 * Its is a combinatorial optimization
 *
 * Given a set of itmes, each with a mass w and a value v, determine the number of each item
 * to include in a collection so that total weight M is less that or equal to a given limit and total value is
 * large as possible
 *
 * UseCase: Resource allocation where there are financial constraint
 *
 * Running Time : O(n * w)
 *
 */
public class Knapsack {

    private int numOfItems;
    private int capacityOfKnapsack;
    private int [][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    public Knapsack(int numOfItems,
                    int capacityOfKnapsack,
                    int[] weights,
                    int[] values
    ) {
        this.numOfItems = numOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.knapsackTable = new int[numOfItems + 1][ capacityOfKnapsack + 1];
        this.weights = weights;
        this.values = values;
    }

    public void solve() {
        // Time complexity O(N * W)

        for (int i =1; i < numOfItems +1; i ++) {
            for (int w =1; w <capacityOfKnapsack+ 1; w++) {

                // Not taking item i
                int notTakingItem = knapsackTable[i-1][w];

                int takingItem = 0;
                if (weights[i] <= w) {
                    takingItem = values[i] +  knapsackTable[i-1][w- weights[i]];
                }
                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }

        totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
    }

    public void showResult() {
        System.out.println("Total benefit: " + totalBenefit);

        for (int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
                System.out.println("We take the item: # " + n);
                w = w - weights[n];
            }
        }
    }

    public static void main(String []args) {

        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        int [] weightOfItems = new int[numOfItems +1];
        weightOfItems[1] = 4;
        weightOfItems[2] = 2;
        weightOfItems[3] = 3;

        int [] profitOfItems = new int[numOfItems +1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        Knapsack knapsack = new Knapsack(numOfItems, capacityOfKnapsack, weightOfItems,profitOfItems);
        knapsack.solve();
        knapsack.showResult();
    }
}
