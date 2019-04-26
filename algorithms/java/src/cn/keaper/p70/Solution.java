package cn.keaper.p70;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Solution {

    /**
     * recursion approach will out of time limit
     * iteration is faster
     * actually, tail recursion can be transformed iteration
     */
    public int climbStairs(int n) {
        if(n == 1 || n == 0){
            return 1;
        }
        int a = 1,b = 1, c = 2;
        while (n - 2 > 0){
            a = b;
            b = c;
            c = a + b;
            n--;
        }
        return  c;
    }
}
