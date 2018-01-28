package algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloodFillTest {

    FloodFill ff = new FloodFill();

    @Test
    public void normalCase() {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int[][] ans = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}};
        int[][] ret = ff.floodFill(arr, 1, 1, 2);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                assertEquals(ans[i][j], ret[i][j]);
            }
        }
    }

    @Test
    public void duplicateCase() {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 1}};
        int[][] ans = {
                {0, 0, 0},
                {0, 1, 1}};
        int[][] ret = ff.floodFill(arr, 1, 1, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                assertEquals(ans[i][j], ret[i][j]);
            }
        }
    }
}
