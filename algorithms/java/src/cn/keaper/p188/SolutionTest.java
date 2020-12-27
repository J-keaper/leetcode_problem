package cn.keaper.p188;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,4,1, 2},
            new int[]{3,2,6,5,0,3, 2},
            new int[]{3,2,6,5,0,3, 3},
            new int[]{3,2,6,5,0,3,4,3,1,2,6, 3}
    );

    @Test
    public void maxProfit() {
        cases.forEach(c -> {
            System.out.println(solution.maxProfit(c[c.length - 1], Arrays.copyOf(c, c.length - 1)));
            System.out.println(solution.maxProfit1(c[c.length - 1], Arrays.copyOf(c, c.length - 1)));
            System.out.println();
        });
    }
}