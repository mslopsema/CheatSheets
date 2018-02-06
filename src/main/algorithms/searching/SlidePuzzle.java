package algorithms.searching;

import java.util.*;

/**
 * Sliding Puzzle
 * https://leetcode.com/problems/sliding-puzzle/description/
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 */
public class SlidePuzzle {

    private final static int ROWS = 2;
    private final static int COLS = 3;
    private final static int SIZE = ROWS * COLS;

    class board {
        int[][] arr;
        int distance;
        int row;
        int col;

        board(int[][] arr, int distance, int row, int col) {
            this.distance = distance;
            this.arr = arr;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Simple Breadth First Search implementation for Sliding Puzzle Game (2x3 board)
     * Each possible move is to swap the '0' with an adjacent tile.
     * e.g.
     *   ^
     * < 0 >
     *   v
     * @param arr
     * @return
     */
    public int slidingPuzzle(int[][] arr) {
        if (!isSolvable(arr)) return -1;
        if (isSolved(arr)) return 0;
        final HashSet<Integer> used = new HashSet<Integer>();
        used.add(serialize(arr));



        int row = 0;
        int col = 0;
        for  (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (arr[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }

        Queue<board> q = new LinkedList<board>();
        q.add(new board(deepCopy(arr), 0, row, col));

        while (!q.isEmpty()) {
            board b = q.poll();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i + j != -1 && i + j != 1) continue;
                    if (b.row + i < 0 || b.row + i >= ROWS) continue;
                    if (b.col + j < 0 || b.col + j >= COLS) continue;

                    int[][] temp = deepCopy(b.arr);
                    temp[b.row][b.col] = temp[b.row + i][b.col + j];
                    temp[b.row + i][b.col + j] = 0;

                    if (isSolved(temp)) return b.distance + 1;
                    int hash = serialize(temp);
                    if (used.contains(hash)) continue;
                    used.add(hash);
                    q.add(new board(temp, b.distance + 1, b.row + i, b.col + j));
                }
            }
        }
        return -1;
    }

    /**
     * For converting a 2x3 integer array (values 0 -> 5) to a bitmask.
     * Each value will comprise half of a byte (4 bits).
     * e.g. {{1, 2, 3}, {4, 5, 0}} -> 344865
     *               0    5    4    3    2    1
     *  0000 0000 0000 0101 0100 0011 0010 0001
     * @param arr integer array to be converted
     * @return
     */
    public static int serialize(int[][] arr) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ret |= (arr[i][j]) << (4 * count++);
            }
        }
        return ret;
    }

    /**
     * For converting bitmask to 2x3 integer array (opposite of serialize(int[][] arr) function).
     * @param val bitmask
     * @return
     */
    public static int[][] deserialize(int val) {
        int count = 0;
        int[][] arr = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                arr[i][j] = 15 & (val >> (4 * count++));
            }
        }
        return arr;
    }

    /**
     * Validity Checker
     * https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
     * Simply count the number of 'inversions' and return true if even.
     * Definition of an the number of inversions :
     *     An inversion is when a tile of higher value preceeds a tile of lower value.
     *     Thus the solved puzzle has 0 inversions
     * @return
     */
    private boolean isSolvable(int[][] arr) {
        int inversions = 0;
        for (int i = 0; i < SIZE; i++) {
            if (arr[getRow(i)][getCol(i)] == 0) continue;
            for (int j = i + 1; j < SIZE; j++) {
                if (arr[getRow(j)][getCol(j)] == 0) continue;
                if (arr[getRow(i)][getCol(i)] > arr[getRow(j)][getCol(j)]) inversions++;
            }
        }
        return inversions % 2 == 0;
    }

    private int getRow(int val) {
        return val / COLS;
    }

    private int getCol(int val) {
        return val % COLS;
    }

    private boolean isSolved(int[][] arr) {
        return arr[0][0] == 1 &&
               arr[0][1] == 2 &&
               arr[0][2] == 3 &&
               arr[1][0] == 4 &&
               arr[1][1] == 5 &&
               arr[1][2] == 0;
    }

    private int[][] deepCopy(int[][] arr) {
        int[][] ret = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                ret[i][j] = arr[i][j];
            }
        }
        return ret;
    }
}
