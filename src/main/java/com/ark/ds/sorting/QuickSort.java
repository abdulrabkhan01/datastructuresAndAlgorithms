package com.ark.ds.sorting;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <p> Quick Sort using random element as Pivot. </p>
 *
 * @author AbdulR
 */
public enum QuickSort {
    INSTANCE;

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (start == end) return;
        if (start < end) {
            int pivot = partitionArrayOverRandomPivot(a, start, end);
            quickSort(a, 0, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    /**
     * <p> Partition the Array over Random Pivot from Start to End. </p>
     *
     * @param a     - Array to be sorted.
     * @param start - Start Index.
     * @param end   - End Index.
     * @return - Pivot Index.
     */
    private int partitionArrayOverRandomPivot(int[] a, int start, int end) {
        int random = ThreadLocalRandom.current().nextInt(start, end + 1);
        swap(a, start, random); //Swapping with start to reuse- partitionArrayOverStartPivot method
        return partitionArrayOverStartPivot(a, start, end);
    }

    /**
     * <p> Partition the array such that all elements less than pivot will be
     * in left part of the array and all elements greater than the pivot
     * are at the right part of the array, and pivot is at it correct location.</p>
     *
     * @param a     - Array to be sorted.
     * @param start - Start Index.
     * @param end   - End Index.
     * @return - Pivot Index.
     */
    private int partitionArrayOverStartPivot(int[] a, int start, int end) {
        int pivot = a[start];
        int indexToFindPivotCorrectPos = start + 1;
        //Find Correct Location for the Pivot
        for (int nextIndex = start + 1; nextIndex <= end; nextIndex++) {
            if (a[nextIndex] < pivot) {
                swap(a, nextIndex, indexToFindPivotCorrectPos);
                indexToFindPivotCorrectPos++;
            }
        }
        int pivotIndex = indexToFindPivotCorrectPos - 1;
        swap(a, pivotIndex, start); //Move Pivot to its correct location.
        return pivotIndex;
    }

    private void swap(int[] a, int index1, int index2) {
        if (index1 == index2) return;
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

}
