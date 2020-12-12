package cn.keaper.p252;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 */
public class Solution {

    /**
     * 先排序，然后比较是否重合
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
