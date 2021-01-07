package cn.keaper.p41;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,0},
            new int[]{3,4,-1,1},
            new int[]{3,4,-1,7},
            new int[]{7,8,9,11,12},
            new int[]{},
            new int[]{-5},
            new int[]{1},
            new int[]{2}
    );

    @Test
    public void firstMissingPositive() {
        cases.forEach(c -> {
            System.out.println(solution.firstMissingPositive(c));
            System.out.println(solution.firstMissingPositive1(c));
            System.out.println(solution.firstMissingPositive2(c));
            System.out.println();
        });
    }
}