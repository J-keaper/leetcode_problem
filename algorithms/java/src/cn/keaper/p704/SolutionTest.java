package cn.keaper.p704;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{-1,0,3,5,9,12, 9},
            new int[]{-1,0,3,5,9,12, 2},
            new int[]{-1,0,3,5,9,12, 3},
            new int[]{-1,0,3,5,9,12, 12},
            new int[]{-1,0,3,5,9,12, 13},
            new int[]{-1,0,3,5,9,12, -1},
            new int[]{-1,0,3,5,9,12, -2}
            );

    @Test
    public void search() {
        cases.forEach(c -> {
            System.out.println(solution.search(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println(solution.search1(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println();
        });

    }
}