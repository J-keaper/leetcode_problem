package cn.keaper.p48;

/**
 * https://leetcode.com/problems/rotate-image/
 */
class Solution {

    /**
     * 首先沿着水平中线翻转一次，然后沿着主对角线翻转一次
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 沿着水平中线翻转一次
        for (int i = 0; i < (n >> 1); i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n-1-i, j);
            }
        }
        // 沿着主对角线翻转一次
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix,int i, int j, int p, int q){
        int t = matrix[p][q];
        matrix[p][q] = matrix[i][j];
        matrix[i][j] = t;
    }
}