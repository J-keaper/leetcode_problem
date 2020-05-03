package cn.keaper.p16;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{-1,2,1,-4, 1},
            new int[]{1,1,1,0, -100},
            new int[]{0,2,1,-3, 1}
    );

    @Test
    public void threeSumClosest() {
        cases.forEach( c -> System.out.println(
                solution.threeSumClosest(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
    }
}