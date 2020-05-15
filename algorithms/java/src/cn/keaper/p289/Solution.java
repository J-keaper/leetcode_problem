package cn.keaper.p289;

/**
 * https://leetcode.com/problems/game-of-life/
 */
public class Solution {

    /**
     *
     * 比较容易想到的办法是复制一个数组出来计算每个细胞的状态，能否不用额外的数组呢？
     * 我们注意到在数组是int类型，但是其值只有0、1两种状态，也就是只是用了第一位
     * 我们可以将细胞的下一轮状态存在第二位，最后将所有值右移一位即可
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0){
                    board[i][j] = board[i][j] | ((getLiveCount(board, i, j) == 3 ? 1 : 0) << 1);
                }else {
                    int count = getLiveCount(board, i, j);
                    board[i][j] = board[i][j] | (((count == 2 || count == 3) ? 1 : 0) << 1);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getLiveCount(int[][] board, int i, int j){
        int[] dx = new int []{-1,-1,-1,0,0,1,1,1};
        int[] dy = new int []{-1,0,1,-1,1,-1,0,1};
        int res = 0;
        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if(nx >= 0 && nx < board.length && ny >=0 && ny < board[0].length){
                 res += (board[nx][ny] & 1);
            }
        }
        return res;
    }


}
