package cn.keaper.p18;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1, 0, -1, 0, -2, 2, 0},
            new int[]{1, 0, -1, 0, -2, 2, 1},
            new int[]{1, 0, -1, 0, -2, 2, 2}
    );

    @Test
    public void fourSum() {
        cases.forEach( c -> System.out.println(
                solution.fourSum(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
    }
}