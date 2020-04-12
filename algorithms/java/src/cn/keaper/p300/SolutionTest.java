package cn.keaper.p300;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{10,9,2,5,3,7,101,18},
            new int[]{10,9,2,4,5,3,7,101,18},
            new int[]{10,9,2,5,3,7,101,18}
    );

    @Test
    public void lengthOfLIS() {
        cases.forEach(c -> System.out.println(solution.lengthOfLIS(c)));
    }

    @Test
    public void lengthOfLIS1() {
    }
}