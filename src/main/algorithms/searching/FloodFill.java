package algorithms.searching;

public class FloodFill {
    public int[][] floodFill(int[][] arr, int row, int col, int to) {
        int from = arr[row][col];
        if (to != from) floodFill(arr, row, col, to, from);
        return arr;
    }

    private void floodFill(int[][] arr, int row, int col, int to, int from) {
        if (row < 0 || row >= arr.length) return;
        if (col < 0 || col >= arr[0].length) return;
        if (arr[row][col] != from) return;

        arr[row][col] = to;
        floodFill(arr, row - 1, col, to, from);
        floodFill(arr, row + 1, col, to, from);
        floodFill(arr, row, col - 1, to, from);
        floodFill(arr, row, col + 1, to, from);
    }
}
