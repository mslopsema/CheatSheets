package test.algorithms.arrays;

import main.Algorithms.arrays.MedianOfTwoSortedArrays;
import org.junit.Test;
import utils.ArrayBuilder;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();

    @Test
    public void testBaseCase() {
        int[] arr1 = {};
        int[] arr2 = {1};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(1.0, ans, 0.01);
    }

    @Test
    public void testReverseBaseCase() {
        int[] arr1 = {1};
        int[] arr2 = {};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(1.0, ans, 0.01);
    }

    @Test
    public void testSingleCase() {
        int[] arr1 = {1};
        int[] arr2 = {2};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(1.5, ans, 0.01);
    }

    @Test
    public void testNormalCase() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(4.0, ans, 0.01);
    }

    @Test
    public void testReverseNormalCase() {
        int[] arr1 = {3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(4.0, ans, 0.01);
    }

    @Test
    public void testEvenCase() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(4.5, ans, 0.01);
    }

    @Test
    public void testReverseEvenCase() {
        int[] arr1 = {6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(4.5, ans, 0.01);
    }

    @Test
    public void testDisjointCase() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {101, 102, 103, 104, 105};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(53.0, ans, 0.01);
    }

    @Test
    public void testReverseDisjointCase() {
        int[] arr1 = {101, 102, 103, 104, 105};
        int[] arr2 = {1, 2, 3, 4, 5};
        double ans = motsa.findMedianSortedArrays(arr1, arr2);
        assertEquals(53.0, ans, 0.01);
    }

    @Test
    public void powerTest() {
        int size1 = (int) (Math.random() * 10000);
        int size2 = (int) (Math.random() * 10000);
        int[] arr1 = ArrayBuilder.random(Integer.MIN_VALUE / 100,Integer.MAX_VALUE / 100, size1);
        int[] arr2 = ArrayBuilder.random(Integer.MIN_VALUE / 100,Integer.MAX_VALUE / 100, size2);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        double ans1 = motsa.findMedianSortedArrays(arr1, arr2);
        double ans2 = motsa.findMedianSortedArrays(arr2, arr1);
        assertEquals(ans1, ans2, 0.01);
    }
}
