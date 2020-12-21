package cn.keaper.p746;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    private final List<int[]> cases = Arrays.asList(
            new int[]{10,15,20},
            new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
            new int[]{3,2,3,2,4,5,2,1,2,3,5,3},
            new int[]{4,5,2,1,2,3,5,3}

    );

    @Test
    public void minCostClimbingStairs() {
        cases.forEach(c -> {
            System.out.println(solution.minCostClimbingStairs(c));
            System.out.println(solution.minCostClimbingStairs1(c));
            System.out.println();

        });
    }
}