package com.ark.ds.sorting.objects;

/**
 * <p> Insertion Sort for Objects </p>
 */
@SuppressWarnings("rawtypes")
public class InsertSortObject<ObjectType extends Comparable> {

    public void sort(ObjectType[] array) {
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            ObjectType currentElement = array[currentIndex];
            int indexToCompare = currentIndex;
            //noinspection unchecked
            while (indexToCompare > 0 && array[indexToCompare - 1].compareTo(currentElement) > 0) {
                array[indexToCompare] = array[--indexToCompare]; // Perform Shifting to make place for current element.
            }
            //Place Current Element at its current position
            array[indexToCompare] = currentElement;
        }
    }
}
