package Sorting;

import java.util.Arrays;

/**
 * Bubble Sort Algorithm
 * @author Mike
 * Method
 * 1. Scan the array until it is sorted.
 * 2. On each pass, compare adjacent elements.
 *    If they are wrongly oriented, swap them.
 * Complexity
 * 1. Time  : O(N^2) - Worst Case
 * 2. Space : O(1) - In place method
 */
public class SortBubble implements SortAlgorithm {
    public static void main(String args[]) {
        int[] arr = new int[]{0,9,6,4,2,2,1,9,7,0,2,9,5,6,2,9,2,6,7,8};
        System.out.println(Arrays.toString(arr));
        SortAlgorithm sa = new SortBubble();
        System.out.println(Arrays.toString(sa.sort(arr)));
    }
    
    @Override
    public int[] sort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }
}