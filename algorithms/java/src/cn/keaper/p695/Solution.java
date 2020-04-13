package cn.keaper.p695;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class Solution {

    /**
     * 深度优先搜索
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    res = Math.max(res, maxAreaOfIsland(grid, i, j));
                }
            }
        }
        return res;
    }

    private int maxAreaOfIsland(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        int ans = 1;
        grid[i][j] = 0;
        ans += maxAreaOfIsland(grid, i + 1, j);
        ans += maxAreaOfIsland(grid, i - 1, j);
        ans += maxAreaOfIsland(grid, i, j + 1);
        ans += maxAreaOfIsland(grid, i, j - 1);
        return ans;
    }



}
