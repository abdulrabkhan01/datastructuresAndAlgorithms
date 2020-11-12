package com.ark.ds.sorting.objects;

/**
 * <p> Insertion Sort for Objects </p>
 */
public class InsertSortObject<T extends Comparable> {

    public void sort(T[] array) {
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            T currentElement = array[currentIndex];
            int indexToCompare = currentIndex;
            while (indexToCompare > 0 && array[indexToCompare - 1].compareTo(currentElement) > 0) {
                array[indexToCompare] = array[--indexToCompare]; // Perform Shifting to make place for current element.
            }
            //Place Current Element at its current postion
            array[indexToCompare] = currentElement;
        }
    }
}
