package cn.keaper.p941;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,1,0},
            new int[]{0,1,2},
            new int[]{1,2,1},
            new int[]{1,2,3,4,4,5},
            new int[]{5,4,4,3,2,1},
            new int[]{1,2,3,4,5,6},
            new int[]{1,2,3,4,5,6,2},
            new int[]{2,6,5,4,3,2,1},
            new int[]{3,4,4,5,4,3},
            new int[]{2,3,4,5,4,3}
    );

    @Test
    public void validMountainArray() {
        cases.forEach(c -> System.out.println(solution.validMountainArray(c)));
    }
}