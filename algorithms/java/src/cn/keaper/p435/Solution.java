package cn.keaper.p435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class Solution {


    /**
     * 贪心算法
     * 1. 从区间集合 intervals 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
     * 2. 把所有与 x 区间相交的区间从区间集合 intervals 中删除。
     * 3. 重复步骤 1 和 2，直到 intervals 为空为止。之前选出的那些 x 就是最大不相交子集。
     *
     * 将区间集合按照end排序之后可以方便的找到重合与当前区间重合的区间
     *
     * 类似题目：p452
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int res = intervals.length - 1;
        int index = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= index){
                res--;
                index = intervals[i][1];
            }
        }
        return res;
    }
}
