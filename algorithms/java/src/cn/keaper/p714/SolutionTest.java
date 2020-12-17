package cn.keaper.p714;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1, 3, 2, 8, 4, 9, 2},
            new int[]{1, 3, 2, 8, 4, 9, 9}
            );

    @Test
    public void maxProfit() {
        cases.forEach(c -> {
            System.out.println(solution.maxProfit(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println(solution.maxProfit1(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println(solution.maxProfit2(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println(solution.maxProfit3(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
            System.out.println();
        });
    }
}