package cn.keaper.p342;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class Solution {

    /**
     * 1. num > 0
     * 2. num is the power of 2
     * 3. The only one-bit of the two's complement binary representation of the specified number is odd bit
     *    equals
     *    The number of zero-bit at the end of the two's complement binary representation of the specified number is even
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && ( num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //        return num > 0 && (num & (num - 1)) == 0 && (Integer.numberOfTrailingZeros(num) & 1) == 0;
    }
}
