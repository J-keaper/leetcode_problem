package cn.keaper.p259;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 */
public class Solution {

    /**
     * 首先排序，然后使用双指针左右夹逼，同时记录数量
     */
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum < target){
                    res += (r - l);
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
}
