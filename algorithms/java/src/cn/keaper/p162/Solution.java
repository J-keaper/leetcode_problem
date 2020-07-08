package cn.keaper.p162;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class Solution {

    /**
     * 一遍迭代
     * 时间复杂度：O(N)
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }


    /**
     * 因为题目只需要找到一个峰值即可，所以可以用二分的思想
     * 如果中间元素处于上坡，那么在其右侧一定存在一个峰值(可能是最后一个元素)
     * 同理 如果中间元素处于下坡，那么在其左侧一定存在一个峰值(可能是第一个元素)
     */
    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r){
            int m = (l + r) >>> 1;
            if(nums[m + 1] > nums[m]){
                l = m;
            }else{
                r = m;
            }
        }
        return nums[l] > nums[r] ? l : r;
    }

}
