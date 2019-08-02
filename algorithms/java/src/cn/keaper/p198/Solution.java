package cn.keaper.p198;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class Solution {

    /**
     * Define res[i] as the maximum amount of money that can be achieved from the 0th to the ith house,
     * consider if rob the ith house.If yes,res[i] = res[i-2] + nums[i],else res[i] = res[i-1].
     * So, we can get this:res[i] = max(res[i-1],res[i-2] + nums[i])
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
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Integer.max(nums[0],nums[1]);
        for (int i = 2 ; i < nums.length ; i ++){
            res[i] = Integer.max(res[i-1],res[i-2] + nums[i]);
        }
        return res[res.length - 1];
    }
}
