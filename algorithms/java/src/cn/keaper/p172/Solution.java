package cn.keaper.p172;


/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class Solution {

    /**
     * answer is the number of 5 in the prime factorization of n
     *  n / 5 + n / 25 + n / 125 + n / 625 + ...
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0){
            res += n / 5;
            n /= 5;
        }
        return res;
    }


    /**
     * n / 5 + n / 25 + n / 125 + n / 625 + ...
     */
    public int trailingZeroes1(int n) {
        int res = 0;
        long f = 5;
        while (n >= f){
            res += n / f;
            f += (f << 2);
        }
        return res;
    }
}

