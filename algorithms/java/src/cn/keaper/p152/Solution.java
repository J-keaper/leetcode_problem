package cn.keaper.p152;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Solution {

    /**
     * 假设max[i]表示以nums[i]为结尾的最大子数组乘积
     * 假设min[i]表示以nums[i]为结尾的最小子数组乘积
     * max[i]的转移方程为下面三个值中的最大值，min[i]的转移方程为下面三个值中的最小值
     *    1. max[i-1] * ans[i], 区间范围大于1
     *    2. min[i-1] * ans[i], 区间范围大于1
     *    3. ans[i], 区间范围等于1
     *
     * 同时考虑max和min的原因是 负负得正
     * 因为状态之与 i-1 的状态有关，所以可以优化空间
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevMax = max, prevMin = min;
            max = max(prevMax * nums[i], prevMin * nums[i], nums[i]);
            min = min(prevMin * nums[i], prevMax * nums[i], nums[i]);
            ans = Integer.max(ans, max);
        }
        return ans;
    }

    private int max(int a, int b, int c){
        return Integer.max(a,Integer.max(b,c));
    }


    private int min(int a, int b, int c){
        return Integer.min(a,Integer.min(b,c));
    }
}
