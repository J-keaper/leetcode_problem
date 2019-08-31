package cn.keaper.p264;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class Solution {


    /**
     * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     * because every number can only be divided by 2, 3, 5, we can split the sequence to three groups as below:
     * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     * We can find that every sub sequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
     * Then we use similar merge method as merge sort, to get every ugly number from the three sub sequence.
     * Every step we choose the smallest one, and move one step after,including nums with same value.
     */
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for(int i = 1 ; i < n ; i ++){
            int min = Math.min(ugly[i2] * 2,Math.min(ugly[i3] * 3 , ugly[i5] * 5));
            ugly[i] = min;
            if(ugly[i2] * 2 == min){
                i2 ++;
            }
            if(ugly[i3] * 3 == min){
                i3 ++;
            }
            if(ugly[i5] * 5 == min){
                i5 ++;
            }
        }
        return ugly[n - 1];
    }
}
