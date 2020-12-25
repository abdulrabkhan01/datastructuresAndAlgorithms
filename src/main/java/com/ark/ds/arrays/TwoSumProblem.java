package com.ark.ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * Given an array return the indices of two numbers if their sum matched to a given value.
 */
public class TwoSumProblem {

    public static int[] checkTwoSum(int[] array, int value) {
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer diff = value - array[i];
            Integer matchedElement = map.get(diff);
            if (matchedElement != null) {
                output[0] = i;
                output[1] = matchedElement;
                break;
            }
            map.put(array[i], i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        int[] output = checkTwoSum(array, 6);
        print(output);

    }

    private static void print(int[] output) {
        Arrays.stream(output).forEach(i -> System.out.println(i));
    }
}




