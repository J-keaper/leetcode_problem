package cn.keaper.p179;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{10, 2},
            new int[]{3,30,34,5,9}
        );

    @Test
    public void largestNumber() {
        cases.forEach(c -> System.out.println(solution.largestNumber(c)));
    }
}