package cn.keaper.p945;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,2},
            new int[]{3,2,1,2,1,7},
            new int[]{7,4,3,3,1,1},
            new int[]{1,4,5,4,10}
    );

    @Test
    public void minIncrementForUnique() {
        cases.forEach(c -> System.out.println(solution.minIncrementForUnique(c)));
    }
}