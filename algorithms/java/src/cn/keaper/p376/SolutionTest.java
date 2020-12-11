package cn.keaper.p376;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,1},
            new int[]{},
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{2,1},
            new int[]{2,1,2},
            new int[]{1,7,4,9,2,5},
            new int[]{1,17,5,10,13,15,10,5,16,8},
            new int[]{1,2,3,4,5,6,7,8,9}
    );

    @Test
    public void wiggleMaxLength() {
        cases.forEach(c -> System.out.println(solution.wiggleMaxLength(c)));
    }
}