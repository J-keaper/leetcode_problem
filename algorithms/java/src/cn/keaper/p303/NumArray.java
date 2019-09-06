package cn.keaper.p303;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {


    /**
     * store prefix sum,prefix[i] = sum(nums[0],nums[1],...,nums[i])
     * sum(nums[i],nums[i+1],...,nums[j]) = prefix[j] - prefix[i-1]
     */

    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

}
