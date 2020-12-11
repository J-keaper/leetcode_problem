package cn.keaper.review.p289;

public class Solution {

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = getLiveCount(board, i, j);
                if(board[i][j] == 0){
                    board[i][j] = board[i][j] | ((live == 3 ? 1 : 0) << 1);
                }else{
                    board[i][j] = board[i][j] | ((live == 2 || live == 3 ? 1 : 0) << 1);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }


    public int getLiveCount(int[][] board, int i, int j){
        int count = 0;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[i].length) {
                continue;
            }
            count += board[x][y]&1;
        }
        return count;
    }

}