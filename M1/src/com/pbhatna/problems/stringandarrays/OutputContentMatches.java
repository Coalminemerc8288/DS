package com.pbhatna.problems.stringandarrays;

/**
 * During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the
 * rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're
 * given n teams, you need to output their final contest matches in the form of a string.
 *
 * The n teams are given in the form of positive integers from 1 to n, which represents their initial rank.
 * (Rank 1 is the strongest team and Rank n is the weakest team.)
 * We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition.
 * During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 *
 * Solution:
 *
 */
public class OutputContentMatches {

    public static void main (String[] args) {
        System.out.println(findContestMatch(7));
    }

    public static String findContestMatch(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i <=n ; i++) {
            sb.append(String.valueOf(i));
        }

        char[] teams = sb.toString().toCharArray();
        int p1 = 0;
        int p2 = teams.length-1;

        StringBuilder out = new StringBuilder();
        while (p1 <= p2) {
            out.append("(").append(teams[p1]).append(",").append(teams[p2]).append(")");
            p1 +=1;
            p2 -=1;
        }
        return out.toString();
    }
}
