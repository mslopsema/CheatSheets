package algorithms.searching;

import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;

public class SlidePuzzleTest {

    private SlidePuzzle mSlidePuzzle = new SlidePuzzle();

    @Test
    public void baseCase() {
        int[][] arr = {{1, 2, 3}, {4, 5, 0}};
        int ret = mSlidePuzzle.slidingPuzzle(arr);
        assertEquals(0, ret);
    }

    @Test
    public void impossibleCase() {
        int[][] arr = {{1, 2, 3}, {5, 4, 0}};
        int ret = mSlidePuzzle.slidingPuzzle(arr);
        assertEquals(-1, ret);
    }

    @Test
    public void standardCase2() {
        int[][] arr = {{2, 1, 3}, {5, 4, 0}};
        int ret = mSlidePuzzle.slidingPuzzle(arr);
        assertEquals(14, ret);
    }

    @Test
    public void standardCase() {
        int[][] arr = {{4, 1, 2}, {5, 0, 3}};
        int ret = mSlidePuzzle.slidingPuzzle(arr);
        assertEquals(5, ret);
    }

    @Test
    public void maxCase() {
        int[][] arr = {{4, 5, 0}, {1, 2, 3}};
        int ret = mSlidePuzzle.slidingPuzzle(arr);
        assertEquals(21, ret);
    }

    @Test
    public void serialize() {
        int[][] arr = {{1, 2, 3}, {4, 5, 0}};
        int ret = mSlidePuzzle.serialize(arr);
        assertEquals(344865, ret);
    }

    @Test
    public void serializeBoth() {
        int val = 344865;
        int ret = SlidePuzzle.serialize(SlidePuzzle.deserialize(val));
        assertEquals(val, ret);
    }
}
