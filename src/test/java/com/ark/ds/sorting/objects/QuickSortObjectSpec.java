package com.ark.ds.sorting.objects;

import com.ark.ds.sorting.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <p> Spec to test Quick Sort for the array of Objects. </p>
 *
 * @author AbdulR
 */
public class QuickSortObjectSpec {

    @Test
    public void testSpec1() {
        String[] strings = {"XYZ", "ABC", "BBA"};
        QuickSortObject<String> stringQuickSortObject = new QuickSortObject<>();
        stringQuickSortObject.sort(strings);
        assertArrayEquals(new String[]{"ABC", "BBA", "XYZ"}, strings);
    }

    @Test
    public void testSpec2() {
        Integer[] integerWrappers = {100, -1, -2, 4, 15, 999, 5};
        QuickSortObject<Integer> integerQuickSortObject = new QuickSortObject<>();
        integerQuickSortObject.sort(integerWrappers);
        assertArrayEquals(new Integer[]{-2, -1, 4, 5, 15, 100, 999}, integerWrappers);
    }

}
