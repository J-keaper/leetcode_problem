package cn.keaper.p376;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Solution {

    /**
     *
     * 如果要使最后的序列是摆动序列，我们可能需要删除一些元素
     * 我们不能删除波峰或者波谷，因为删除波峰或者波谷都有可能是的上坡或者下坡减少
     * 所以我们最后要求的其实是上坡和下坡的数量
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Boolean prevAsc = null;
        int len = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                continue;
            }
            boolean asc = nums[i] - nums[i + 1] < 0;
            if(prevAsc == null || asc != prevAsc){
                len++;
            }
            prevAsc = asc;
        }
        return len + 1;
    }
}
