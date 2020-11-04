package cn.keaper.p57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class Solution {

    /**
     * 直接顺序扫描一遍即可
     * 对于不重叠的部分直接赋值
     * 对于交叉的部分，扩展新区间的边界值加入替换原区间中重叠部分即可
     */
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int i = 0,j = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            res[j++] = intervals[i++];
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[j++] = newInterval;

        while (i < intervals.length){
            res[j++] = intervals[i++];
        }
        return Arrays.copyOfRange(res, 0, j);
    }


    /**
     * 找到新区间的左右两个值在原区间中的位置，可以用二分
     * 按照不同的情况区分，求出最后新区间应该扩展到的位置
     * 然后对比一遍求出新的区间序列
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] flat = new int[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            flat[i*2] = intervals[i][0];
            flat[i*2+1] = intervals[i][1];
        }
        int down = newInterval[0] , up = newInterval[1];

        int downIndex = Arrays.binarySearch(flat, down);
        if(downIndex < 0){
            downIndex = -downIndex - 1;
        }
        down = (downIndex & 1) == 0 ? down : flat[downIndex - 1];

        int upIndex = Arrays.binarySearch(flat, up);
        if(upIndex >= 0){
            up = (upIndex & 1) == 0 ? flat[upIndex + 1] : up;
        }else{
            upIndex = -upIndex - 1;
            up = (upIndex & 1) == 0 ? up : flat[upIndex];
        }

        List<Integer> temp = new ArrayList<>();
        int i = 0;
        while (i < flat.length && flat[i] < down){
            temp.add(flat[i]);
            i++;
        }
        temp.add(down);
        while (i < flat.length && flat[i] <= up){
            i++;
        }
        temp.add(up);
        while (i < flat.length){
            temp.add(flat[i]);
            i++;
        }
        int[][] res = new int[temp.size()>>1][2];
        for (int j = 0; j < (temp.size()>>1); j++) {
            res[j] = new int[]{temp.get(j*2), temp.get(j*2+1)};
        }
        return res;
    }


}
