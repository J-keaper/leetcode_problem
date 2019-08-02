package cn.keaper.p202;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class Solution {

    private static int [] square = new int[]{0,1,4,9,16,25,36,49,64,81};

    /**
     * cost: 0ms
     */
    public boolean isHappy(int n) {
        while (n >= 10) {
            int sum = 0;
            while (n != 0){
                sum += square[n % 10];
                n /= 10;
            }
            n = sum;
        }
        return n == 1 || n == 7;
    }

    /**
     * cost: 1ms
     */
    public boolean isHappy2(int n) {
        BitSet h = new BitSet();
        while (true) {
            int sum = 0;
            while (n != 0){
                sum += square[n % 10];
                n /= 10;
            }
            n = sum;
            if(n == 1) {
                return true;
            }
            if(h.get(n)){
                return false;
            }
            h.set(n);
        }
    }

}