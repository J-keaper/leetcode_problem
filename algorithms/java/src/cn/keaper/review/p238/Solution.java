package cn.keaper.review.p238;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            res[i] = i == 0 ? 1 : res[i - 1] * nums[i - 1];
        }

        int p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= p;
            p = p * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1,2})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
