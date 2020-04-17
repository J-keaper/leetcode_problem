package cn.keaper.p994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Solution {


    /**
     * 标准BFS，注意记录轮次
     */
    public int orangesRotting(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 1) count ++;
                if(grid[i][j] == 2) queue.add(new int[]{i,j});
            }
        }

        int times = 0;
        while (count > 0 && !queue.isEmpty()){
            times ++;
            int roundSize = queue.size();
            for (int t = 0; t < roundSize; t++) {
                int[] pos = queue.poll();
                int i = pos[0], j = pos[1];
                int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
                for (int d = 0; d < 4 ; d ++){
                    int ni = dx[d] + i, nj = dy[d] + j;
                    if(0 <= ni && ni < N && 0 <= nj && nj < M && grid[ni][nj] == 1){
                        grid[ni][nj] = 2;
                        count--;
                        queue.add(new int[]{ni,nj});
                    }
                }
            }
        }
        return count > 0 ? -1 : times;
    }


    /**
     * BFS的思想
     * 循环传播腐烂，直到一次传播没有发生任何变化，表明腐烂已经无法传播。传播过程中记录次数，并且用一个变量维护本次是否有变化
     * 判断结束时，是否还有新鲜的橘子，如果有，说明不可能不存在新鲜的，否则返回传播次数
     *
     * 每次传播时，需要遍历每个格子，需要保证本次传播的腐烂不会继续在本次传播中二次传播
     * 所以可以将传播轮次 也添加到 grid[i][j]中，grid[i][j] = k (k >= 2)表示 这是在第k-2次轮传播中腐烂的
     * 每次遍历都只传播上一轮腐烂的即可
     *
     */
    public int orangesRotting1(int[][] grid) {
        boolean isChange;
        int times = 0;
        do {
            isChange = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == times + 2){
                        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
                        for (int d = 0; d < 4 ; d ++){
                            int ni = dx[d] + i, nj = dy[d] + j;
                            if(0 <= ni && ni < grid.length && 0 <= nj && nj < grid[i].length && grid[ni][nj] == 1){
                                grid[ni][nj] = 2 + times + 1;
                                isChange = true;
                            }
                        }
                    }
                }
            }
            times ++;
        }while (isChange);

        for (int[] row : grid) {
            for (int c : row) {
                if (c == 1) {
                    return -1;
                }
            }
        }
        return times - 1;
    }
}
