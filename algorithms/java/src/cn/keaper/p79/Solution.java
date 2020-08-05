package cn.keaper.p79;

/**
 * https://leetcode.com/problems/word-search/
 */
public class Solution {

    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return word.length() == 0;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == word.charAt(0) && exist(board, used, x, y, word.substring(1))) return true;
            }
        }
        return false;
    }

    /**
     * 从[x,y]位置开始是否能够匹配到word
     */
    private boolean exist(char[][] board, boolean[][] used,int x, int y, String word) {
        if(word.length() == 0){
            return true;
        }
        used[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[x].length &&
                    !used[nx][ny] && board[nx][ny] == word.charAt(0) &&
                    exist(board, used, nx, ny, word.substring(1))){
                return true;
            }
        }
        used[x][y] = false;

        return false;
    }
}