package com.ark.ds.arrays;

import java.util.Arrays;

/**
 * <p> Given an array and given value delete that value and perform left shift for remaining elements
 * .</p>
 */
public class ArrayLeftShift {

    public static int performLeftShift(int[] array, int elementToBeDeleted) {
        int arrayLen = array.length;
        //Handle the case when element to be deleted is the last element

        for (int i = 0; i < array.length - 1; i++) {
            int currElement = array[i];
            if (currElement == elementToBeDeleted) {
                arrayLen--;
                for (int j = i + 1; j < array.length; j++) {
                    array[j - 1] = array[j]; //Performing left shift
                }
                //Add the deleted element to the last index
                array[array.length - 1] = -1;
            }
        }
        if (array[arrayLen - 1] == elementToBeDeleted) {
            array[arrayLen - 1] = -1;
            return arrayLen - 1;
        }
        return arrayLen;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        //int[] a = {0, 1, 2, 3, 4, 5,3};
        Arrays.stream(a).forEach(element -> System.out.print(" " + element));
        int modifiedLenAfterShift = performLeftShift(a, 2);
        System.out.println();
        System.out.println("\nNew array length " + modifiedLenAfterShift);
        Arrays.stream(a).forEach(element -> System.out.print(" " + element));
    }
}
