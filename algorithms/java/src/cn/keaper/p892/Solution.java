package cn.keaper.p892;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class Solution {


    /**
     * 加法思路
     * 求每个方块在每个方向上对表面积的贡献度
     * 网格上每个位置的方块
     *  在垂直方向上的贡献度为 只能是 0(没有方块) 或者 2(有方块)
     *  在水平方向的贡献度，如果比相邻位置高，贡献度为高度差值，否则贡献度为0，如果是边界，贡献度为高度
     */
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += grid[i][j] > 0 ? 2 : 0;
                res += i - 1 < 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i - 1][j], 0);
                res += j - 1 < 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i][j - 1], 0);
                res += i + 1 >= grid.length  ? grid[i][j] : Math.max(grid[i][j] - grid[i + 1][j], 0);
                res += j + 1 >= grid[i].length ? grid[i][j] : Math.max(grid[i][j] - grid[i][j + 1], 0);
            }
        }
        return res;
    }



    /**
     * 减法思路：每个立方体6个面，求出原本的面积减去相邻方块之间减少的面积
     * 垂直方向减少的是 (高度 - 1) * 2
     * 水平方向减少的是 (相邻方块较小高度 * 2)
     */
    public int surfaceArea1(int[][] grid) {
        int count = 0, faces = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += grid[i][j]; // 原表面积
                if(grid[i][j] > 0) {
                    faces += grid[i][j] - 1; // 垂直方向减少的面积
                }
                if(j + 1 < grid[i].length){
                    faces += Math.min(grid[i][j],grid[i][j + 1]); // 水平方向与右边相邻方块减少的面积
                }
                if(i + 1 < grid.length) {
                    faces += Math.min(grid[i][j],grid[i + 1][j]); // 水平方向与下边相邻方块减少的面积
                }
            }
        }
        return count * 6 - faces * 2;
    }

}
