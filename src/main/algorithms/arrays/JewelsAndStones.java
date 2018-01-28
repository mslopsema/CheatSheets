package algorithms.arrays;

/**
 * Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 * <p>
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so
 * "a" is considered a different type of stone from "A".
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        boolean[] arr = new boolean[128];

        // Load the 'Jewel Array'
        for (int i = 0; i < J.length(); i++) arr[J.charAt(i)] = true;

        // Check each character in 'S' to see if it exists in the 'Jewel Array'
        int count = 0;
        for (int i = 0; i < S.length(); i++) if (arr[S.charAt(i)]) count++;
        return count;
    }
}
