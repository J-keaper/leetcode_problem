package cn.keaper.p162;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,1},
            new int[]{1,2,1,3,5,6,4},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{3,2,1}
    );

    @Test
    public void findPeakElement() {
        cases.forEach(c -> System.out.println(solution.findPeakElement(c)));
    }


    @Test
    public void findPeakElement1() {
        cases.forEach(c -> System.out.println(solution.findPeakElement1(c)));
    }
}