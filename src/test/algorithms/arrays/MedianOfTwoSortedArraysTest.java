package test.algorithms.arrays;

import main.Algorithms.arrays.MedianOfTwoSortedArrays;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();

    @Test
    public void testBaseCase() {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(2.0, ans, 0.01);
    }
}
