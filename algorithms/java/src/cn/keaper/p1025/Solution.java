package cn.keaper.p1025;

/**
 * https://leetcode.com/problems/divisor-game/
 */
public class Solution {

    /**
     * Even's factors can be even or odd,odd's factors only be odd.
     *
     * So if N is even
     * 1. Round one: Alice minus a odd factor from N, N become odd;so that Bob only minus a odd factor, N become even
     * 2. Round two: Alice continue minus odd;Bob only minus odd
     * 3. repeating...(Alice can let N is even at the end of every round.)
     * 5. Round x, N = 2, Alice minus 1, N = 1, Alice win.
     *
     * On the contrary,if N is odd
     * Alice only minus a odd factor in first round,so Bob will take the initiative,
     * because Bob can let N is even at the end of every round, so Alice will lose.
     *
     */
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}
