package cn.keaper.p66;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int [digits.length + 1];
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9){
            ans[i + 1] = digits[i] = 0;
            i --;
        }
        if(i >= 0){
            ans[i + 1] = digits[i] = digits[i] + 1;
            return digits;
        }
        ans[i + 1] = 1;
        return ans;
    }

}
