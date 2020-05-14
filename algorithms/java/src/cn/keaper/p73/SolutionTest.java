package cn.keaper.p73;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{1,0,3}},
            new int[][]{{1,2,3}},
            new int[][]{{1},{0},{3}},
            new int[][]{{1},{2},{3}},
            new int[][]{{1,1,1},
                    {1,0,1},
                    {1,1,1}},
            new int[][]{
                    {0,1,2,0},
                    {3,4,5,2},
                    {1,3,1,5}
            }
    );

    @Test
    public void setZeroes() {
        cases.forEach(c -> {
            solution.setZeroes(c);
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        });

    }
}