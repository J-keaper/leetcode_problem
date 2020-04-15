package cn.keaper.p836;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class Solution {


    /**
     * 如果两个矩形有重叠，则两个矩形在x轴的投影投影一定相交，在y轴的也一定相交
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0],rec2[0]) < Math.min(rec1[2],rec2[2]) &&
                Math.max(rec1[1],rec2[1]) < Math.min(rec1[3],rec2[3]);
    }

    /**
     * 排除两个矩形不重叠的情况
     * 矩形1 在 矩形2 的 上下左右 四个方向则不重叠
     */
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2]
                || rec1[2] <= rec2[0]
                || rec1[1] >= rec2[3]
                || rec1[3] <= rec2[1]);
    }




}
