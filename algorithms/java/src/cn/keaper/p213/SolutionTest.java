package cn.keaper.p213;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
        new int[]{},
        new int[]{2},
        new int[]{5,6},
        new int[]{2,3,2},
        new int[]{1,2,3,1},
        new int[]{2,7,9,3,1}
    );

    private Solution solution = new Solution();

    @Test
    public void rob() {
        cases.forEach(c -> System.out.println(solution.rob(c)));
    }
}