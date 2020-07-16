package cn.keaper.p29;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class Solution {

    /**
     * 将两个数都转换成负数，并且记录是否异号
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            throw new IllegalArgumentException("divisor is zero");
        }
        if(dividend == 0){
            return 0;
        }
        boolean diff = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }
        int res = _divide2(dividend, divisor);
        // 如果是这种情况，会发生溢出
        if(res == Integer.MIN_VALUE && !diff){
            return Integer.MAX_VALUE;
        }
        return diff ? res : -res;
    }

    /**
     * 用 dividend 一直去减去 divisor，直到无法再减为止
     *
     * 两个参数都是负数
     * 为了防止溢出，结果用负数表示
     */
    private int _divide(int dividend, int divisor){
        int factor = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            factor--;
        }
        return factor;
    }

    /**
     * 上面一个一个减效率太低，我们可以加快减 divisor 的速度，以指数形式去减 divisor
     * 假设A/B，我们找到一个数n，使得 2^(n+1) * B > A > 2^n * B，那么结果至少为2^n
     * 我们再对 (A - 2^n * B) 进行同样的操作结果相加，递归进行直到剩下的数 小于 B
     *
     * 举例来说，计算19/3，8*3 > 19 > 4*3，那么结果至少有 4
     * 在计算 (19-4*3)/3，也就是7/3，4*3 > 7 > 2*3，那么结果至少有 2
     * 在计算 (7-2*3)/3，也就是1/3无法再相除，对上述结果求和 4+2 = 6
     *
     * 两个参数都是负数
     * 为了防止溢出，结果用负数表示
     */
    private int _divide2(int dividend, int divisor) {
        if(dividend > divisor){
            return 0;
        }
        int c = 1, d = divisor;
        while (dividend - d <= d){  // 等于 dividend <= d*2，为了防止溢出不使用(d<<1)
            d<<=1;
            c<<=1;
        }
        return -c + _divide2(dividend - d, divisor);
    }
}