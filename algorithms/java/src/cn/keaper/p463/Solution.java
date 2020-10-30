package cn.keaper.p463;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class Solution {

    /**
     * 如果没有相邻，一个陆地贡献四个单位的周长
     * 相邻一个周长减2
     */
    public int islandPerimeter4(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        int N = grid.length, M = grid[0].length;
        for(int i = 0; i < N; i ++){
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 1){
                    count += 4;
                    if(i > 0 && grid[i-1][j] == 1) count -= 2;
                    if(j > 0 && grid[i][j-1] == 1) count -= 2;
                }
            }
        }
        return count;
    }

    /**
     * 计算陆地的数量和相邻的边数
     * 最后周长等于 陆地个数*4 - 相邻边数*2
     */
    public int islandPerimeter3(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int islands = 0, neighbors = 0;
        int N = grid.length, M = grid[0].length;
        for(int i = 0; i < N; i ++){
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 1){
                    islands++;
                    if(i > 0 && grid[i-1][j] == 1) neighbors++;
                    if(j > 0 && grid[i][j-1] == 1) neighbors++;
                }
            }
        }
        return islands * 4 - neighbors * 2;
    }

    /**
     * 考虑每个陆地对于整体周长的贡献
     * 在边界上 或者 相邻的是水的时候 贡献度加一
     * 一个陆地最多可以贡献四个单位的周长（极端情况）
     */
    public int islandPerimeter2(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        int N = grid.length, M = grid[0].length;
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        for(int i = 0; i < N; i ++){
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 1){
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M || grid[nx][ny] == 0) count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 扫描一次
     * 边界上且是陆地 周长加一
     * 与相邻的格子不同类型 周长加一
     * 因为顺序扫描，所以只需要与左边和上边相比
     */
    public int islandPerimeter1(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        int N = grid.length, M = grid[0].length;
        for(int i = 0; i < N; i ++){
            for (int j = 0; j < M; j++) {
                if(i == 0) {
                    count += grid[i][j];
                }
                if(i == N -1){
                    count += grid[i][j];
                }
                if(i > 0 && grid[i][j] != grid[i-1][j]) {
                    count++;
                }
                if(j == 0) {
                    count += grid[i][j];
                }
                if(j == M - 1){
                    count += grid[i][j];
                }
                if(j > 0 && grid[i][j] != grid[i][j-1]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 扫描每一行和每一列
     * 如果在边界上并且是陆地 则周长加一
     * 否则如果跨过了陆地和水的编辑 周长也加一
     */
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        int N = grid.length, M = grid[0].length;
        for (int i = 0; i < N; i++) {
            count += grid[i][0];
            for (int j = 1; j < M; j++) {
                if(grid[i][j] != grid[i][j-1]){
                    count++;
                }
            }
            count += grid[i][M - 1];
        }
        for (int i = 0; i < M; i++) {
            count += grid[0][i];
            for (int j = 1; j < N; j++) {
                if(grid[j][i] != grid[j-1][i]){
                    count++;
                }
            }
            count += grid[N - 1][i];
        }
        return count;
    }

}
