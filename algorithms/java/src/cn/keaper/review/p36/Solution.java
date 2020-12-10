package cn.keaper.review.p36;

import java.util.Arrays;

public class Solution {


    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++) {
                if(!check(board[i][j], used)) return false;
            }
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++) {
                if(!check(board[j][i], used)) return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(used,false);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(!check(board[i * 3 + k][j * 3 + l], used)) return false;
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
