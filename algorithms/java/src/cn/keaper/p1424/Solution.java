package cn.keaper.p1424;

import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class Solution {

    /**
     * 每一条对角线上的数的下标(i,j)之和都是相等的
     * 将每条对角线上的数都放到Map中，最后依次输出Map中的数即可
     * 注意对角线上数的顺序
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.computeIfAbsent(i + j, k -> new LinkedList<>());
                map.get(i + j).add(nums.get(i).get(j));
            }
        }
        List<Integer> res = new ArrayList<>();
        map.values().forEach(l -> {
            for (int i = l.size() - 1; i >= 0; i--) {
                res.add(l.get(i));
            }
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
