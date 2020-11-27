package cn.keaper.p454;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/
 */
public class Solution {


    /**
     * 使用两个Map分别保存前两个数组和后两个数组中 两数之和的组合数量
     * 最后将两个Map中 key互为相反数的value相乘 累加即可得到结果
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                sumAB.put(i + j, sumAB.getOrDefault(i + j, 0) + 1);
            }
        }
        Map<Integer, Integer> sumCD = new HashMap<>();
        for (int i : C) {
            for (int j : D) {
                sumCD.put(i + j, sumCD.getOrDefault(i + j, 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : sumAB.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            Integer vCD = sumCD.get(-k);
            if (vCD != null) {
                res += v * vCD;
            }
        }
        return res;
    }

}
