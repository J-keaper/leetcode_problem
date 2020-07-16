package cn.keaper.p34;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{5,7,7,8,8,10, 8},
            new int[]{5,7,7,8,8,10, 7},
            new int[]{5,7,7,8,8,10, 6},
            new int[]{5,7,7,8,8,10, 5},
            new int[]{5,7,7,8,8,10, 10},
            new int[]{ 1},
            new int[]{1, 1},
            new int[]{1, 2},
            new int[]{1,2, 1},
            new int[]{1,2, 2},
            new int[]{1,2, 3}
    );

    @Test
    public void searchRange() {
        cases.forEach(c -> System.out.println(
                Arrays.toString(solution.searchRange(Arrays.copyOf(c, c.length - 1), c[c.length - 1]))));
    }
}