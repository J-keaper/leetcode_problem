package cn.keaper.p1030;

/**
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] dir1 = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int[][] dir2 = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};

        int[][] res = new int[R * C][2];
        int index = 0;
        res[index++] = new int[]{r0,c0};

        int dis = 1;
        while (index < res.length){
            for (int[] d : dir1) {
                int x = r0 + d[0] * dis, y = c0 + d[1] * dis;
                if (x >= 0 && x < R && y >= 0 && y < C) {
                    res[index++] = new int[]{x, y};
                }
            }
            for (int i = 1; i < dis; i++){
                for (int[] d : dir2) {
                    int x = r0 + (d[0]) * i, y = c0 + (d[1]) * (dis - i);
                    if (x >= 0 && x < R && y >= 0 && y < C) {
                        res[index++] = new int[]{x, y};
                    }
                }
            }
            dis++;
        }
        return res;
    }


}
