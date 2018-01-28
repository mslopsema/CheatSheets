package Sorting;

import java.util.Arrays;

/**
 * Insertion Sort Algorithm
 * @author Mike
 * Method
 * 1. Scan the array
 * 2. For each element, move it to the left (swapping as you go)
 *    until it is in the correct position.
 * Complexity
 * 1. Time  : O(N^2) - Worst case (same as bubble sort).
 * 2. Space : O(1) - In place method (same as bubble sort).
 */
public class SortInsertion implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{0,9,6,4,2,2,1,9,7,0,2,9,5,6,2,9,2,6,7,8};
        System.out.println(Arrays.toString(arr));
        SortAlgorithm sa = new SortInsertion();
        System.out.println(Arrays.toString(sa.sort(arr)));
    }
    
    @Override
    public int[] sort(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else break;
            }
        }
        return arr;
    }
}