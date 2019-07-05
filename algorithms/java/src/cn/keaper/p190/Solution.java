package cn.keaper.p190;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class Solution {

    /**
     * Divide and conquer
     * 1. swap adjacent 1 bit
     * 2. swap adjacent 2 bit
     * 3. swap adjacent 4 bit
     * 4. ...
     */
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /**
     * get every bit iteratively
     */
    public int reverseBits1(int n) {
        int res = 0;
        for(int i = 0 ; i < 32 ; i ++){
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }



}
