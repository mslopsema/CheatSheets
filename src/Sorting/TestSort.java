package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TestSort {
    public static void main(String[] args) {
        
        LinkedList<SortAlgorithm> algoList = new LinkedList<SortAlgorithm>();
        algoList.add(new SortBubble());
        algoList.add(new SortInsertion());
        algoList.add(new SortMerge());
        algoList.add(new SortQuick());
        
        int[] arr = randomArray(100000, 100000);
        for (SortAlgorithm sa : algoList) {
            long  srt = System.currentTimeMillis();
            int[] res = sa.sort(Arrays.copyOf(arr, arr.length));
            long  end = System.currentTimeMillis();
            //System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(res));
            System.out.println("[" + sa.getClass().getName() + "] " +
                    validateSortedArray(arr, res) + " " + (end - srt) + "ms");
        }
        
    }
    
    public static int[] randomArray(int length, int itemSize) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = (int) (Math.random() * itemSize + 1);
        return arr;
    }
    
    public static Boolean validateSortedArray(int[] original, int[] sorted) {
        // Check order is sorted MIN -> MAX
        for (int i = 1; i < sorted.length; i++)
            if (sorted[i - 1] > sorted[i]) return false;
        
        // Check sorted array is a permutation of the original array
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i : original) {
            if (frequencyMap.containsKey(i))
                frequencyMap.put(i, frequencyMap.get(i) + 1);
            else frequencyMap.put(i, 1);
        }
        for (int i : sorted) {
            if (!frequencyMap.containsKey(i)) return false;
            frequencyMap.put(i, frequencyMap.get(i) - 1);
            if (frequencyMap.get(i)  < 0) return false;
            if (frequencyMap.get(i) == 0) frequencyMap.remove(i);
        }
        return frequencyMap.isEmpty();
    }
}
