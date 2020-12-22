package cn.keaper.p239;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,3,-1,-3,5,3,6,7, 3},
            new int[]{1,3,-1,5,4,-4,3,6,7, 2},
            new int[]{1,3,-1,5,4,-4,3,6,7, 1}
    );

    @Test
    public void maxSlidingWindow() {
        cases.forEach(c -> {
            System.out.println(Arrays.toString(solution.maxSlidingWindow(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
            System.out.println(Arrays.toString(solution.maxSlidingWindow1(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
            System.out.println(Arrays.toString(solution.maxSlidingWindow2(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));

        });

    }
}