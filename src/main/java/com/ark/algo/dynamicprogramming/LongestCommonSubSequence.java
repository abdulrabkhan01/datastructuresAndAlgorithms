package com.ark.algo.dynamicprogramming;

import java.util.Arrays;

/**
 * Longest common subsequence with big O of 2 to the power n time complexity
 * O(pow(2,n)
 */
public class LongestCommonSubSequence {

    private static String getLCS(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        //Table for memorization
        int[][] table = new int[l1 + 1][l2 + 1];
        //populate the table & calculate lcs length
        int lcsLength = lcs(s1, s2, l1, l2, table);
        System.out.println("LCS Length " + lcsLength);
        //create array to store lcs using the table
        String lcsValue = getLCSString(s1, s2, l1, l2, table, lcsLength);
        return lcsValue;
    }

    private static String getLCSString(String s1, String s2, int l1, int l2, int[][] table, int lcsLength) {
        char[] lcs = new char[lcsLength];
        int i = l1, j = l2, index = lcsLength - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                //Matching char
                lcs[index] = s1.charAt(i - 1);
                //Move diagonally back in table
                i--;
                j--;
                index--;
            } else if (table[i - 1][j] > table[i][j - 1]) {
                //Move to previous row
                i--;
            } else {
                //move to previous column
                j--;
            }
        }
        return String.valueOf(lcs);
    }

    private static int lcs(String s1, String s2, int l1, int l2, int[][] table) {
        for (int row = 0; row <= l1; row++) {
            for (int column = 0; column <= l2; column++) {
                if (row == 0 || column == 0) {
                    table[row][column] = 0;
                } else if (s1.charAt(row - 1) == s2.charAt(column - 1)) {
                    //diagonal
                    table[row][column] = table[row - 1][column - 1] + 1;
                } else {
                    //Max of previous row or previous column
                    table[row][column] = Math.max(table[row - 1][column], table[row][column - 1]);
                }
            }
        }
        return table[l1][l2];

    }

    public static void main(String[] args) {
        String s1 = "acc";
        String s2 = "ac";
        String lcs = getLCS(s1, s2);
        System.out.println(lcs);
    }
}
