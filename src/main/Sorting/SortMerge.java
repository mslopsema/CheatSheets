package Sorting;

import java.util.Arrays;

/**
 * Merge Sort Algorithm (Recursive)
 * @author Mike
 * Method
 * 1. Recursively halve the array until it is size 2 or less.
 * 2. In the sub-array, swap to the correct orientation.
 * 3. Recursively re-merge the sorted sub-arrays.
 * Complexity
 * 1. Time  : O(N*Log(N)) - Log(N) subdivisions multiplied 
 *    by linear time of merging the sorted sub-arrays for
 *    each subdivision.
 * 2. Space : O(N) - For additionally created arrays.
 */
public class SortMerge implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{0,9,6,4,2,2,1,9,7,0,2,9,5,6,2,9,2,6,7,8};
        System.out.println(Arrays.toString(arr));
        SortAlgorithm sa = new SortMerge();
        System.out.println(Arrays.toString(sa.sort(arr)));
    }
    
    @Override
    public int[] sort(int[] arr) {
        int l = arr.length;
        if (l <= 2) {
            if (arr[l - 1] < arr[0]) {
                int temp = arr[l - 1];
                arr[l - 1] = arr[0];
                arr[0] = temp;
            }
        } else {
            // Divide & Sort
            int[] left  = sort(Arrays.copyOfRange(arr, 0, l / 2));
            int[] right = sort(Arrays.copyOfRange(arr, l / 2, l));
            
            // Merge Sorted Arrays
            int ptrL = 0, ptrR = 0;
            for (int i = 0; i < l; i++) {
                if (ptrL >= left.length) {
                    arr[i] = right[ptrR];
                    ptrR++;
                }
                else if (ptrR >= right.length) {
                    arr[i] = left[ptrL];
                    ptrL++;
                }
                else if (left[ptrL] < right[ptrR]) {
                    arr[i] = left[ptrL];
                    ptrL++;
                } else {
                    arr[i] = right[ptrR];
                    ptrR++;
                }
            }
        }
        return arr;
    }
}