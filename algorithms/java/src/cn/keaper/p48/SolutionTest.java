package cn.keaper.p48;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{
                    {1,2,3},
                    {4,5,6},
                    {7,8,9}
            },
            new int[][]{
                    {5,1,9,11},
                    {2,4,8,10},
                    {13,3,6,7},
                    {15,14,12,16}
            }
    );



    @Test
    public void rotate() {
        cases.forEach(c -> {
            solution.rotate(c);
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        });

    }
}