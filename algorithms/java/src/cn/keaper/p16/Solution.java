package cn.keaper.p16;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Solution {


    /**
     * Time：O(N^2)
     * 先排序，然后固定一个元素，对剩余元素夹逼，夹逼过程中计算最小的差值并记录
     * 如果差值等于0，可以直接返回
     *
     * 夹逼操作所提升的效率是将两次遍历转化为一次遍历
     *
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    res = sum;
                    minDiff = diff;
                }
                if (target < sum) r--;
                else if(target > sum)l++;
                else return sum;
            }
        }
        return res;
    }

}
