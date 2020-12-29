package cn.keaper.p330;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,3, 6},
            new int[]{1,5,10, 20},
            new int[]{1,2,2, 5}
    );

    @Test
    public void minPatches() {
        cases.forEach(c -> System.out.println(solution.minPatches(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
    }
}