package cn.keaper.p36;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Solution {


    /**
     * 依次检查每行，每列，每个小九宫格，是否有重复数字，使用数组来记录出现过的数字
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            for(int j = 0; j < 9 ; j++){
                if(!check(board[i][j], used)) return false;
            }
            Arrays.fill(used, false);
            for(int j = 0; j < 9 ; j++){
                if(!check(board[j][i], used)) return false;
            }
        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                Arrays.fill(used, false);
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        if(!check(board[3 * i + p][3 * j + q], used)) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean check(char c, boolean[] used) {
        if(c == '.'){
            return true;
        }
        if(used[c - '0' - 1]){
            return false;
        }
        return used[c - '0' - 1] = true;
    }

}
