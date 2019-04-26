package cn.keaper.p121;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{7,1,5,3,6,4},
            new int[]{7,6,4,3,1},
            new int[]{1,4,5,6},
            new int[]{5,4,4},
            new int[]{2}
    );

    private Solution solution = new Solution();

    @Test
    public void maxProfit() {
        cases.forEach(o -> System.out.println(solution.maxProfit(o)));
    }

    @Test
    public void maxProfit2() {
        cases.forEach(o -> System.out.println(solution.maxProfit2(o)));
    }

    @Test
    public void maxProfit1() {
        cases.forEach(o -> System.out.println(solution.maxProfit1(o)));
    }
}