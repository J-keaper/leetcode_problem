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


    /**
     * 使用一种复杂度为O(N)的排序算法排序
     * 基数排序，由低位到高位
     */
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        // 计算最大值
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        // 临时数组存放每一轮排序后的结果
        int[] stash = new int[nums.length];
        int base = 1; // 记录位数
        while (base <= maxVal){
            int[] radix = new int[10]; // 0-9分别对应数字的个数
            for (int num : nums) {
                radix[(num / base) % 10]++;
            }
            // 计算前缀和，为了方便得到最后每个数字应该所在的位置
            for (int i = 1; i < radix.length; i++) {
                radix[i] += radix[i-1];
            }
            // 使用前缀和数组将数字放到对应位置上，注意这里需要是倒序，因为stash插入顺序是倒着的
            for (int i = nums.length - 1; i >= 0; i--) {
                int mod = (nums[i] / base) % 10;
                stash[radix[mod] - 1] = nums[i];
                radix[mod]--;
            }

            // 将一轮排序后的结果复制到nums，下一轮排序使用
            System.arraycopy(stash, 0, nums, 0, nums.length);
            base *= 10;
        }

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;

    }
}