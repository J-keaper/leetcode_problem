package cn.keaper.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class Solution {

    /**
     * 区间按照左端点排序，然后双指针遍历
     * 有重合则移动右指针，不重合则结果集
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > r){
                res.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else {
                r = Math.max(r,intervals[i][1]);
            }

        }
        res.add(new int[]{l,r});
        return res.toArray(new int[][]{});
    }
}
