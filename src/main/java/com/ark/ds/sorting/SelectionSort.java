package com.ark.ds.sorting;

/**
 * <p> Selection Sort Algorithm. </p>
 * @author  AbdulR
 */
public enum SelectionSort {
    INSTANCE;

    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            int min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(a, i, minIndex);
            }
        }
    }

    private void swap(int[] a, int index1, int index2) {
        if (index1 == index2) return;
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
