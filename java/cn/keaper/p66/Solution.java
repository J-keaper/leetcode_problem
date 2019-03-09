package cn.keaper.p66;

import java.util.Arrays;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{2,8,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,0,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }

}
