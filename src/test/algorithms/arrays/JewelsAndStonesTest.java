package algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JewelsAndStonesTest {

    JewelsAndStones jas = new JewelsAndStones();

    @Test
    public void baseCase() {
        String j = "";
        String s = "";
        int ret = jas.numJewelsInStones(j, s);
        assertEquals(0, ret);
    }

    @Test
    public void normalCase() {
        String j = "aA";
        String s = "aAAbbbb";
        int ret = jas.numJewelsInStones(j, s);
        assertEquals(3, ret);
    }
}
