package com.ark.ds.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> Insertion Sort Spec. </p>
 *
 * @author AbdulR
 * @since 13-Nov-2020
 */
public class InsertionSortSpec {

    @Test
    public void insertionSortSpec1() {
        InsertionSortPrimitives insertionSortPrimitives = new InsertionSortPrimitives();
        int[] array = {1};
        insertionSortPrimitives.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void insertionSortSpec2() {
        InsertionSortPrimitives insertionSortPrimitives = new InsertionSortPrimitives();
        int[] array = {3, 2, 1};
        insertionSortPrimitives.sort(array);
        assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    public void insertionSortSpec3() {
        InsertionSortPrimitives insertionSortPrimitives = new InsertionSortPrimitives();
        int[] array = {3, 2, 1, -1, 0};
        insertionSortPrimitives.sort(array);
        assertArrayEquals(new int[]{-1, 0, 1, 2, 3}, array);
    }

}
