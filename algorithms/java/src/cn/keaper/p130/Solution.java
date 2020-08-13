package cn.keaper.p130;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Solution {


    /**
     * 因为边界的'O'不能被替换，所以从边界的'O'开始寻找连通块，并标记
     * 然后遍历整个网格的每个元素：
     *  1. 如果是'O'，那么肯定不是边界的连通块，可以修改为'X'
     *  2. 如果是标记过的元素，那么将其还原为'O'
     */
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        int N = board.length , M = board[0].length;
        for (int i = 0; i < N; i++) {
            dfs(board, i, 0);
            dfs(board, i, M - 1);
        }
        for (int i = 0; i < M; i++) {
            dfs(board, 0, i);
            dfs(board, N - 1, i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '*';
        int[] di = {0,1,0,-1}, dj = {1,0,-1,0};
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k], nj = j + dj[k];
            dfs(board, ni, nj);
        }
    }


}
