package cn.keaper.p259;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{-2,0,1,3, 2},
            new int[]{-2,0,1,3, 2}
    );

    @Test
    public void threeSumSmaller() {
        cases.forEach(c -> {
            System.out.println(solution.threeSumSmaller(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
        });

    }
}