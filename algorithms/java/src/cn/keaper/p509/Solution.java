package cn.keaper.p509;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Solution {

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if(n <= 1){
            return n;
        }
        int a = 0, b = 1;
        while (n-- >= 2){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


}
