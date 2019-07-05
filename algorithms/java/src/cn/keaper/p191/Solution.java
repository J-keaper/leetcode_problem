package cn.keaper.p191;

public class Solution {

    /**
     * [n & (n-1)] can turn off the rightmost 1-bit in a word, producing  0 if none (e.g., 01011000 -> 01010000):
     * repeat this operation until n equals zero , iterate time is the answer
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0){
            sum ++;
            n &= (n - 1);
        }
        return sum;
    }

    /**
     * Divide and conquer
     */
    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * judge every bit iteratively
     */
    public int hammingWeight1(int n) {
        int res = 0;
        for (int i = 0 ; i < 32 ; i ++){
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

}