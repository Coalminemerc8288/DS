package com.pbhatna.problems.stringandarrays;

import java.util.List;
/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int k =0;
        for (int i = 0; i < triangle.size()-1; i++) {
            for (int j = 0; j < triangle.get(i).size()-1; j++) {
              if (triangle.get(i).get(j) < k) {
                k = triangle.get(i).get(j);
              }
            }
            sum = sum + k;
        }
        return sum;
    }
}
