package cn.keaper.p189;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class Solution {

    /**
     * l is length of nums
     * 1. reverse [0,l)
     * 2. reverse [0,k)
     * 3. reverse [k,l)
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length ;
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k,nums.length);
    }

    public void reverse(int[] nums, int s, int e) {
        for (int i = s; i < (s + e) / 2; i ++) {
            int tmp = nums[i];
            nums[i] = nums[e - i + s - 1];
            nums[e - i + s - 1] = tmp;
        }
    }
}
