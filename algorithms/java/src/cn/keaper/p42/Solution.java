package cn.keaper.p42;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Solution {

    /**
     * 思路一样，考虑将O(N^2) 优化为 O(N)
     * 提前计算每个位置的左边最大值和右边最大值并存储，这两组值是可以扫描一遍得到的
     *
     */
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            left[i] = i == 0 ? height[i] : Math.max(left[i - 1], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = (i == height.length - 1) ? height[i] : Math.max(right[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }


    /**
     * Time：O(N^2)
     * 考虑每个柱子上方能存储的水量等于 Max(左边的最高点,右边的最高点)-柱子高度
     * 特殊地，如果左边或者右边都没有高于当前柱子高度的，那么其上方肯定不能存储水
     */
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = height[i], maxRight = height[i];
            for (int l = i - 1; l >= 0; l--) {
                maxLeft = Math.max(maxLeft, height[l]);
            }
            for (int r = i + 1; r < height.length; r++) {
                maxRight = Math.max(maxRight, height[r]);
            }
            sum += Math.min(maxLeft, maxRight) - height[i];
        }
        return sum;
    }

}
