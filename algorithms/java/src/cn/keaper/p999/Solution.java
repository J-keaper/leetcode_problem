package cn.keaper.p999;

/**
 * https://leetcode.com/problems/available-captures-for-rook/
 */
public class Solution {

    public int numRookCaptures(char[][] board) {
        int Ri = -1, Rj = -1;
        find:for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j] == 'R'){
                    Ri = i;
                    Rj = j;
                    break find;
                }
            }
        }

        int res = 0;
        int[] di = new int[]{0, 1, 0, -1};
        int[] dj = new int[]{1, 0, -1, 0};
        for (int d = 0; d < 4; d++) {
            for (int t = 0; ; t++) {
                int ni = Ri + t * di[d], nj = Rj + t * dj[d];
                if(ni < 0 || ni >= 8 || nj < 0 || nj >=8 || board[ni][nj] == 'B') break;
                if(board[ni][nj] == 'p'){
                    res ++;
                    break;
                }
            }
        }
        return res;
    }



}
