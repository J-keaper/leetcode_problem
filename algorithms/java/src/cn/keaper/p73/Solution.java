package cn.keaper.p73;


/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Solution {


    /**
     * Time: O(N*M)
     * Space: O(1)
     *
     * 实际上每一行每一列只需要一个信息来存储是否需要置零
     * 那么可以使用两个变量预先存储第一行第一列的状态
     * 然后复用第一行和第一列来存储每一行每一列的状态
     *
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rowOne = false, colOne = false;
        for (int i = 0; i < n; i++) {
            if(matrix[i][0] == 0){
                colOne = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if(matrix[0][i] == 0){
                rowOne = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowOne){
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if(colOne){
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * Time: O(N*M)
     * Space: O(N+M)
     *
     * 使用两个bool数组记录每个行每个列是否存在零，然后根据此数组置零
     */
    public void setZeroes1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] row = new boolean[n], col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
