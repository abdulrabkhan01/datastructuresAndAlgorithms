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
        Map<Integer, Element> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer diff = value - array[i];
            Element matchedElement = map.get(diff);
            if (matchedElement != null) {
                output[0] = i;
                output[1] = matchedElement.index;
                break;
            }
            //Otherwise
            Element element = new Element();
            element.index = i;
            element.value = array[i];
            map.put(array[i], element);
        }
        return output;
    }

    private static class Element {
        int value;
        int index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return value == element.value &&
                    index == element.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }
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




