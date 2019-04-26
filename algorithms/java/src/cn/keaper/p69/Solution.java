package cn.keaper.p69;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Solution {

    /**
     * binary search from [0,x]
     */
    public int mySqrt(int x) {
        long l = 0 , r = x;
        while (l <= r ){
            long m = (l + r) / 2;
            long sqr = m * m;
            if(sqr == x){
                return (int)m;
            }
            if(sqr > x){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return (int) r;
    }
}
