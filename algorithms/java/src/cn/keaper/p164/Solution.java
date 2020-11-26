package cn.keaper.p164;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap/
 */
public class Solution {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }


    /**
     * 设长度为 N 的数组中最大值为 max, 最小值为 min
     * 则相邻数字的最大间距不会小于 (max - min) / (N-1)
     * 所以我们将一些将所有的数字分到宽度小于  (max - min) / (N-1) 的 K 个桶中
     * 那么相邻数字的最大间距一定不会在同一个桶中，我们只需维护每个桶中的最小值和最大值即可
     * <p>
     * 最后遍历一遍桶，两个相邻桶中数字的最大间距为 [后一个桶的最小值 - 前一个桶的最大值]
     */
    public int maximumGap1(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int bucketWidth = Math.max((max - min) / (N - 1), 1);
        int bucketCount = (max - min + 1) / bucketWidth;
        if ((max - min + 1) % bucketWidth > 0) {
            bucketCount++;
        }

        int[] bucketMin = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        int[] bucketMax = new int[bucketCount];

        for (int num : nums) {
            int i = (num - min) / bucketWidth;
            bucketMin[i] = Math.min(bucketMin[i], num);
            bucketMax[i] = Math.max(bucketMax[i], num);
        }

        int maxGap = 0, prev = 0;
        for (int i = 1; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - bucketMax[prev]);
            prev = i;
        }
        return maxGap;
    }

}