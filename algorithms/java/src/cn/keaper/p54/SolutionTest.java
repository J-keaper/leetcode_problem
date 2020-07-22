package cn.keaper.p54;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();



    @Test
    public void spiralOrder() {
        System.out.println(solution.spiralOrder(build(0,0)));
        System.out.println(solution.spiralOrder(build(1,1)));
        System.out.println(solution.spiralOrder(build(1,3)));
        System.out.println(solution.spiralOrder(build(3,1)));
        System.out.println(solution.spiralOrder(build(2,3)));
        System.out.println(solution.spiralOrder(build(3,3)));
        System.out.println(solution.spiralOrder(build(3,4)));
    }

    private int[][] build(int n, int m){
        int [][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = i * m + j + 1;
            }
        }
        return matrix;
    }
}