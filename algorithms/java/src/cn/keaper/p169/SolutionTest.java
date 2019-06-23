package cn.keaper.p169;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{1},
            new int[]{3,2,3},
            new int[]{2,2,1,1,1,2,2}
    );

    private Solution solution = new Solution();

    @Test
    public void majorityElement() {
        cases.forEach(c -> System.out.println(solution.majorityElement(c)));
    }

    @Test
    public void majorityElement2() {
        cases.forEach(c -> System.out.println(solution.majorityElement2(c)));
    }
}