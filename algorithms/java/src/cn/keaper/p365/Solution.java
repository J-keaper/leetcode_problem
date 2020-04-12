package cn.keaper.p365;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/water-and-jug-problem/solution/shui-hu-wen-ti-by-leetcode-solution/
     * 每次操作只会让桶里的水总量增加 x，增加 y，减少 x，或者减少 y。
     * 因此只要 找到一对整数 a,b ，使得 ax+by=z 即可。
     * 贝祖定理告诉我们，ax+by=z 有解当且仅当 z 是 x, y 的最大公约数的倍数。
     * 因此我们只需要找到 x, y 的最大公约数并判断 z 是否是它的倍数即可。
     *
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z){
            return false;
        }
        if(x == 0 || y == 0){
            return z == 0 || x + y == 0;
        }
        return z % gcd(x,y) == 0;
    }


    private int gcd(int x, int y){
        while (y != 0){
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}
