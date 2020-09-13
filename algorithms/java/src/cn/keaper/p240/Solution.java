package cn.keaper.p240;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int N = matrix.length, M = matrix[0].length;
        int i = N - 1, j = 0;
        while (i >= 0 && j < M){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

}
