package Sorting;

import java.util.Arrays;

/**
 * Quick Sort Algorithm 
 * @author Mike
 * Method
 * 1. Pick Pivot item (this implementation always uses arr[0].
 * 2. Scan the whole array.
 *    Move all items which are less than or equal to the left.
 *    Move all items which are greater than to the right.
 * 3. Recursively process the sub arrays [left] and [right] of the pivot.
 * 4. Recombine sorted sub-arrays.
 * Complexity
 * 1. Time  : Normally O(N*log(N)); Worst Case O(N^2).
 * 2. Space : log(N) for additional arrays (it can be manipulated to be 
 *    done in-place on a globally accessible array).
 */
public class SortQuick implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{0,9,6,4,2,2,1,9,7,0,2,9,5,6,2,9,2,6,7,8};
        System.out.println(Arrays.toString(arr));
        SortAlgorithm sa = new SortQuick();
        System.out.println(Arrays.toString(sa.sort(arr)));
    }
    
    @Override
    public int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;
        else if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
        } else {
            // Pick Pivot
            int pivot = arr[0];
            // Pick wall (where wall will be the 1 index to the left of
            // the [right] sub-array. In other words, arr[wall] should
            // be less than 'pivot', and all items to the right of 'wall'
            // will be greater than 'pivot'.
            int wall = arr.length - 1;
            while (arr[wall] > pivot && wall > 0) wall--;
            for (int i = 1; i < wall; i++) {
                // Arrange greater than items to the right of the wall
                if (arr[i] > pivot) {
                    int temp = arr[i];
                    arr[i] = arr[wall];
                    arr[wall] = temp;
                    while (arr[wall] > pivot && wall > 0) wall --;
                }
            }
            // place the pivot
            arr[0] = arr[wall];
            arr[wall] = pivot;
            
            int[] left  = sort(Arrays.copyOfRange(arr, 0, wall));
            int[] right = sort(Arrays.copyOfRange(arr, wall + 1, arr.length));
            for (int i = 0; i < left.length;  i++) arr[i] = left[i];
            for (int i = 0; i < right.length; i++) arr[i + wall + 1] = right[i];
        }
        return arr;
    }
}