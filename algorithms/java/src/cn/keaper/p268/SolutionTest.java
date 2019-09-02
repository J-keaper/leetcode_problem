package cn.keaper.p268;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{0},
            new int[]{1,0},
            new int[]{2,0,1},
            new int[]{3,0,1},
            new int[]{9,6,4,2,3,5,7,0,1}
    );

    private Solution solution = new Solution();

    @Test
    public void missingNumber() {
        cases.forEach(c -> System.out.println(solution.missingNumber(c)));
    }
}