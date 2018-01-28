package utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArrayBuilderTest {

    @Test
    public void randomBaseCase() {
        int min = -1;
        int max = 1;
        int[] arr = ArrayBuilder.random(min, max, 100);
        for (int i = 0; i < 100; i++) {
            assert (arr[i] >= min && arr[i] <= max);
        }
    }

    @Test
    public void randomStandardCase() {
        int min = -10;
        int max = 10;
        int[] arr = ArrayBuilder.random(min, max, 100);
        for (int i = 0; i < 100; i++) {
            assert (arr[i] >= min && arr[i] <= max);
        }
    }

    @Test
    public void randomDistribution() {
        int min = -5;
        int max = 5;
        int[] arr = ArrayBuilder.random(min, max, 100);
        int[] frequency = new int[11];
        for (int i = 0; i < 100; i++) frequency[arr[i] + 5]++;
        for (int i = 0; i < 11; i++) assertNotEquals(0, frequency[i]);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(frequency));
    }
}
