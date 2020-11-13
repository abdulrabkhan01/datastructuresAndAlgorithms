package com.ark.ds.sorting.objects;

/**
 * <p> Selection Sort Algorithm for sorting Array of Java Objects. </p>
 *
 * @author AbdulR
 */
public class SelectionSortObject<ObjectType extends Comparable> {

    public void sort(ObjectType[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            ObjectType min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(min) < 0) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(a, i, minIndex);
            }
        }
    }

    private void swap(ObjectType[] a, int index1, int index2) {
        if (index1 == index2) return;
        ObjectType temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
