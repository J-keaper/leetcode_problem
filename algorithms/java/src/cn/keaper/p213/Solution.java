package cn.keaper.p213;


/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Solution {


    /**
     * @see cn.keaper.p198.Solution
     * Difference between this problem and house-robber(problem 198) is
     * first house and last house can not be robed at the same time.
     * So,consider two situations:
     * 1. not rob first house
     * 2. not rob last house
     * the max value of this two situations is the answer.
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Integer.max(nums[0],nums[1]);
        }
        return Integer.max(rob(nums,0,nums.length - 1),rob(nums,1,nums.length));
    }

    private int rob(int[] nums, int begin, int end){
        int[] res = new int[end - begin];
        res[0] = nums[begin];
        res[1] = Integer.max(nums[begin],nums[begin + 1]);
        for (int i = 2 ; i < end - begin ; i ++){
            res[i] = Integer.max(res[i-1],res[i-2] + nums[begin + i]);
        }
        return res[end - begin - 1];
    }

}
