package cn.keaper.review.p73;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        boolean firstRow = false, firstColumn = false;
        int N = matrix.length, M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            if(matrix[i][0] == 0){
                firstColumn = true;
                break;
            }
        }
        for (int i = 0; i < M; i++) {
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for (int i = 0; i < M; i++) {
                matrix[0][i] = 0;
            }
        }
        if(firstColumn){
            for (int i = 0; i < N; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
