package cn.keaper.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Solution {

    /**
     * 使用四个值x1,x2,y1,y2划定四个界限
     * 遍历完一行之后，则将会对的界限加一或者减一
     * 直到界限重合
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int N = matrix.length, M = matrix[0].length;
        int x1 = 0, x2 = N - 1, y1 = 0, y2 = M - 1;
        while (x1 <= x2 && y1 <= y2){
            for (int i = y1; i <= y2; i++) {
                res.add(matrix[x1][i]);
            }
            x1++;
            for (int i = x1; i <= x2; i++) {
                res.add(matrix[i][y2]);
            }
            y2--;
            if(x1 > x2 || y1 > y2) break;
            for (int i = y2; i >= y1; i --){
                res.add(matrix[x2][i]);
            }
            x2--;
            for(int i = x2; i >= x1; i --){
                res.add(matrix[i][y1]);
            }
            y1++;
        }
        return res;
    }

}
