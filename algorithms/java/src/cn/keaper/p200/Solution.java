package cn.keaper.p200;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class Solution {

    private static final int[] dx = new int[]{0,1,0,-1};
    private static final int[] dy = new int[]{1,0,-1,0};

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int N = grid.length, M = grid[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res += dfs(grid, i, j) ? 1 : 0;
            }
        }
        return res;
    }

    private boolean dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        if(grid[i][j] == '0'){
            return false;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k], nj = j + dy[k];
            dfs(grid, ni, nj);
        }
        return true;
    }

}
