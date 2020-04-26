package cn.keaper.p1423;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class Solution {

    /**
     * 计算一个前缀和，然后遍历求出中间段(也就是不在最后结果中的数)的最小值，总和减去这个值即为结果
     */
    public int maxScore(int[] cardPoints, int k) {
        int[] sum = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            sum[i + 1] = sum[i] + cardPoints[i];
        }
        int len = cardPoints.length, remain = len - k;
        int minMid = sum[sum.length - 1];
        for (int i = 0; i <= k; i++) {
            minMid = Math.min(minMid, sum[remain + i] - sum[i]);
        }
        return sum[sum.length - 1] - minMid;
    }


    /**
     * 计算前缀和后缀和，遍历k个位置，计算最大值
     */
    public int maxScore1(int[] cardPoints, int k) {
        int[] prefix = new int[cardPoints.length + 1];
        int[] suffix = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }
        for (int i = 0; i < cardPoints.length; i++) {
            suffix[i + 1] = suffix[i] + cardPoints[cardPoints.length - 1 - i];
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, prefix[i] + suffix[k - i]);
        }
        return res;
    }

}
