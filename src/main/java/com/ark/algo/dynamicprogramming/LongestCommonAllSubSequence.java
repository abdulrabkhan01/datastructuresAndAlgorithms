package com.ark.algo.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;


/**
 * <p> Print all Longest common subsequence using Dynamic Programming table.</p>
 */
public class LongestCommonAllSubSequence {


    public static final String BLANK = "";

    private static Set<String> getAllLCS(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        //Table for memorization
        int[][] table = new int[l1 + 1][l2 + 1];
        //populate the table & calculate lcs length
        int len = lcs(s1, s2, l1, l2, table);
        System.out.println("LCS length "+len);
        //create array to store lcs using the table
        return getAllLCS(s1, s2, l1, l2, table);
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


    private static Set<String> getAllLCS(String s1, String s2, int l1, int l2, int[][] table) {
        Set<String> allLCS = new HashSet<>();
        if (l1 == 0 || l2 == 0) {
            allLCS.add(BLANK);
            return allLCS;
        }

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            Set<String> intermediateLCS = getAllLCS(s1, s2, l1 - 1, l2 - 1, table);
            for (String str : intermediateLCS) {
                allLCS.add(str + s1.charAt(l1 - 1));
            }
            //intermediateLCS.forEach(str -> allLCS.add(str + s1.charAt(l1 - 1)));
        } else {
            if (table[l1 - 1][l2] >= table[l1][l2 - 1]) {
                allLCS = getAllLCS(s1, s2, l1 - 1, l2, table);
            }

            if (table[l1][l2 - 1] >= table[l1 - 1][l2]) {
                allLCS.addAll(getAllLCS(s1, s2, l1, l2 - 1, table));
            }
        }
        return allLCS;
    }

    public static void main(String[] args) {
        String s1 = "abcabcaa";
        String s2 = "acbacba";
        Set<String> lcs = getAllLCS(s1, s2);
        System.out.println(lcs);
    }

}
