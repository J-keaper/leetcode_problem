package cn.keaper.p53;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Solution {

    /**
     * O(N) , online approach
     * Calculate sum prefix one by one.
     * If sum become negative,we need to reset sum to 0,because this prefix can not increase total value.
     */
    public int maxSubArray(int[] nums) {
        long sum = 0,maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return (int) maxSum;
    }

    /**
     * O(N*LogN)
     * divide and conquer approach
     */
    public int maxSubArray2(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int mid = nums.length / 2;
        int leftMax = maxSubArray(Arrays.copyOfRange(nums,0,mid));
        int rightMax = maxSubArray(Arrays.copyOfRange(nums,mid,nums.length));

        int midMaxLeft = nums[mid - 1],midMaxRight = nums[mid];
        int sum = midMaxLeft;
        for (int i = mid - 2 ; i >= 0; i --){
            sum += nums[i];
            midMaxLeft = Integer.max(midMaxLeft,sum);
        }

        sum = midMaxRight;
        for (int i = mid + 1; i < nums.length ; i ++){
            sum += nums[i];
            midMaxRight = Integer.max(midMaxRight,sum);
        }
        return Integer.max(Integer.max(leftMax,rightMax),midMaxLeft + midMaxRight);
    }
}
