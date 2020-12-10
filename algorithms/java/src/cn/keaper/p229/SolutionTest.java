package cn.keaper.p229;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{3,2,3},
            new int[]{1},
            new int[]{1,1,1,3,3,2,2,2},
            new int[]{0,0,0,3,3,1,1,1}
    );

    @Test
    public void majorityElement() {
        cases.forEach(c -> System.out.println(solution.majorityElement(c)));
    }
}