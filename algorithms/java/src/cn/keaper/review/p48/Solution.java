package cn.keaper.review.p48;

public class Solution {


    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i ++){
            for (int j = 0; j < matrix[i].length; j++) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    void swap(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
