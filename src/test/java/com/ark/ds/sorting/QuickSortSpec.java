package com.ark.ds.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <p> Quick Sort Spec. </p>
 *
 * @author AbdulR
 * @since 13-Nov-2020
 */
public class QuickSortSpec {

    @Test
    public void quickSortSpec1() {
        int[] array = {1};
        QuickSort.INSTANCE.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void quickSortSpec2() {
        int[] array = {3, 2, 1};
        QuickSort.INSTANCE.sort(array);
        assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    public void quickSortSpec3() {
        int[] array = {3, 2, 1, -1, 0};
        QuickSort.INSTANCE.sort(array);
        assertArrayEquals(new int[]{-1, 0, 1, 2, 3}, array);
    }

    @Test
    public void quickSortSpec4() {
        int[] array = {3, 2, 1, -1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 13, -15};
        QuickSort.INSTANCE.sort(array);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, -15, -1, 0, 1, 2, 3, 13, Integer.MAX_VALUE}, array);
    }

    @Test
    public void quickSortSpec5() {
        int[] array = {1, 3, 4, 15, 1, 2, 1, 3, 5, 19};
        QuickSort.INSTANCE.sort(array);
        assertArrayEquals(new int[]{1, 1, 1, 2, 3, 3, 4, 5, 15, 19}, array);
    }
}
