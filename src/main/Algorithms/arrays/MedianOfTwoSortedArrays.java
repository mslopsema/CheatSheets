package main.algorithms.arrays;

/**
 * Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6};
        // merged : {1, 2, 3, 3, 4, 4, 5, 5, 6}; -> Median = 4
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        System.out.println(motsa.findMedianSortedArrays(arr1, arr2));
    }

    /**
     * Brute force method.
     * Merge the arrays and find the median of the composite array.
     * Time Complexity O(N + M)
     * Space Complexity O(N + M)
     * @param arr1
     * @param arr2
     * @return
     */
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] fullArr = new int[arr1.length + arr2.length];

        int a = 0, b = 0;
        for (int i = 0; i < fullArr.length; i++) {
            if (b >= arr2.length) {
                fullArr[i] = arr1[a];
                a++;
            } else if (a >= arr1.length) {
                fullArr[i] = arr2[b];
                b++;
            } else if (arr1[a] < arr2[b]) {
                fullArr[i] = arr1[a];
                a++;
            } else {
                fullArr[i] = arr2[b];
                b++;
            }
        }
        /*
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(fullArr));
        System.out.println(fullArr.length);
        */

        if (fullArr.length % 2 == 0) {
            int med = fullArr.length / 2;
            return (fullArr[med - 1] + fullArr[med]) / (double) 2;
        } else {
            return fullArr[fullArr.length / 2];
        }
    }
}