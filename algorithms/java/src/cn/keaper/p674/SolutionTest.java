package cn.keaper.p674;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,3,5,4,6},
            new int[]{2,2,2,2,2},
            new int[]{1,3,5,6},
            new int[]{1,3,5,4,2,3,4,5}
    );

    @Test
    public void findLengthOfLCIS() {
        cases.forEach(c -> System.out.println(solution.findLengthOfLCIS(c)));
    }
}