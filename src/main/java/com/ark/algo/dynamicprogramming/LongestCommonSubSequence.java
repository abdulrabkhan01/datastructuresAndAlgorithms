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
        initializeTable(table);
        //populate the table & calculate lcs length
        int lcsLength = lcs(s1, s2, l1, l2, table);
        //create array to store lcs using the table
        String lcsValue = getLCSString(s1, s2, l1, l2, table, lcsLength);
        return lcsValue;
    }

    private static String getLCSString(String s1, String s2, int l1, int l2, int[][] table, int lcsLength) {
        char[] lcs = new char[lcsLength];
        int i = l1, j = l2, index = lcsLength - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
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

    private static void initializeTable(int[][] table) {
        //Fill all rows with -1
        for (int[] row : table) {
            Arrays.fill(row, -1);
        }
    }

    private static int lcs(String s1, String s2, int l1, int l2, int[][] table) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (table[l1 - 1][l2 - 1] != -1) {
            return table[l1 - 1][l2 - 1];
        }
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            table[l1 - 1][l2 - 1] = 1 + lcs(s1, s2, l1 - 1, l2 - 1, table);
        } else {
            table[l1 - 1][l2 - 1] = Math.max(lcs(s1, s2, l1 - 1, l2, table), lcs(s1, s2, l1, l2 - 1, table));
        }
        return table[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        String s1 = "axybanzti";
        String s2 = "aynbcnzto";
        String lcs = getLCS(s1, s2);
        System.out.println(lcs);
    }
}
