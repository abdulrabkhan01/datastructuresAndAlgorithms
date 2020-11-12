package com.ark.ds.sorting;

public class InsertionSortPrimitives {
    /**
     * <p> Insertion sort work by iterating over the element from position 1 to n-1 and comparing
     * all elements previous to the current element, until current element is placed at its correct
     * position
     * https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
     * </p>
     *
     * @param array
     * @return
     */
    public void sort(int[] array) {
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            int currentElement = array[currentIndex], indexToCompare = currentIndex;
            while (indexToCompare > 0 && array[indexToCompare - 1] > currentElement) {
                array[indexToCompare] = array[--indexToCompare]; // Perform Shifting to make place for current element.
            }
            //Place Current Element at its current postion
            array[indexToCompare] = currentElement;
        }
    }
}
