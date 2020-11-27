package cn.keaper.p164;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private final Solution solution = new Solution();

    private final List<int[]> cases = Arrays.asList(
            new int[]{10},
            new int[]{},
            new int[]{3,6},
            new int[]{3,6,9},
            new int[]{3,6,10},
            new int[]{3,6,9,1},
            new int[]{1,1,1,1},
            new int[]{3,6,9,12,11,32,43,21,1,13,14,34,26,47,23}
    );

    @Test
    public void maximumGap() {
        cases.forEach(c -> {
            System.out.println(solution.maximumGap(c));
            System.out.println(solution.maximumGap1(c));
            System.out.println(solution.maximumGap2(c));
            System.out.println();
        });
    }
}