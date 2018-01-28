package utils;

public class ArrayBuilder {

    public static int[] random(int min, int max, int size) {
        if (min > max) return null;

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }
}
