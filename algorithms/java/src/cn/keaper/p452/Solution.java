package cn.keaper.p452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class Solution {

    /**
     * 按照区间右端点排序，
     * 贪心思想，将第一箭射在第一个区间的右端点，依次遍历后续的区间
     * 直到当前区间不能被这只箭覆盖，然后在当前区间重新射一只箭，以此类推
     *
     * 相似题目：p435
     */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int res = 0;
        int index = points[0][1];
        for (int[] point : points) {
            if(point[0] > index){
                index = point[1];
                res++;
            }
        }
        return res + 1;
    }
}
