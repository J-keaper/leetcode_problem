package cn.keaper.p326;

/**
 * https://leetcode.com/problems/power-of-three/
 */
public class Solution {

    /**
     * The possible values of n where we should return true are [3^0,3^1,...,3^19] since int upper limit.
     * Since 3 is a prime number,the only divisors of 3^19 are 3^0,3^1,...,3^19,
     * therefore all we need to do is divide 3^19 by n.
     */
    public boolean isPowerOfThree(int n) {
        // 1162261467 = 3^19
        return n > 0 && 1162261467 % n == 0;
    }


    public boolean isPowerOfThree1(int n) {
        if(n <= 0){
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
