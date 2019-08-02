package cn.keaper.p198;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases  = Arrays.asList(
            new int[]{1},
            new int[]{2,2},
            new int[]{2,3},
            new int[]{2,3,2},
            new int[]{1,2,3,1},
            new int[]{2,7,9,3,1},
            new int[]{4,4,45,57,42,51,2,34,54,23,54,65},
            new int[]{24,76,93,34,154,4,2,41,4}
    );

    private Solution solution = new Solution();

    @Test
    public void rob() {
        cases.forEach(c -> System.out.println(solution.rob(c)));
    }
}