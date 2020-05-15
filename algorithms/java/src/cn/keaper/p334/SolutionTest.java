package cn.keaper.p334;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,3,2},
            new int[]{1,2,3,4,5},
            new int[]{5,4,3,2,1},
            new int[]{2,1,5,4,3},
            new int[]{2,1,5,4,3,6}
    );

    @Test
    public void increasingTriplet() {
        cases.forEach(c -> System.out.println(solution.increasingTriplet(c)));

    }
}