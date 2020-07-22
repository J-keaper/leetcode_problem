package cn.keaper.p50;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Solution {

    /**
     * 快速幂算法，考虑N为正数
     * 如果N为偶数 X^N = ( X^(N/2) )^2
     * 如果N为奇数 X^N = ( X^(N/2) )^2 * X
     *
     * N 为负数，用 1.0 除以正数情况下的结果即可
     */
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -((long)n));
    }

    private double quickMul(double x, long n){
        if(n == 0){
            return 1.0;
        }
        double res = quickMul(x, n >> 1);
        return ((n&1) == 0) ? res * res : res * res * x;
    }

}
