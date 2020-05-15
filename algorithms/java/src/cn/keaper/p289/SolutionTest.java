package cn.keaper.p289;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{
                    {0,1,0},
                    {0,0,1},
                    {1,1,1},
                    {0,0,0},
            },
            new int[][]{{}}
    );
    @Test
    public void gameOfLife() {
        cases.forEach(c -> {
            solution.gameOfLife(c);
            for (int[] ints : c) {
                for (int a : ints) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        });
    }
}