package cn.keaper.p122;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private List<int[]> cases = Arrays.asList(
            new int[]{7,1,5,3,6,4},
            new int[]{1,2,3,4,5},
            new int[]{7,6,4,3,1},
            new int[]{5,4,3,2,1},
            new int[]{1,2,2,4,5,2,1},
            new int[]{2,3},
            new int[]{7,1}
    );

    private Solution solution = new Solution();

    @Test
    public void maxProfit() {
        cases.forEach(o -> {
            System.out.println(solution.maxProfit(o));
            System.out.println(solution.maxProfit1(o));
            System.out.println(solution.maxProfit2(o));
            System.out.println(solution.maxProfit3(o));

            System.out.println();

        });
    }

    @Test
    public void maxProfit1() {
        cases.forEach(o -> System.out.println(solution.maxProfit1(o)));
    }
}