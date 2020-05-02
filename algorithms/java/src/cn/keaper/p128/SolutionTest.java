package cn.keaper.p128;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{2},
            new int[]{2,4},
            new int[]{2,3},
            new int[]{1,2,0,1},
            new int[]{100,4,200,1,3,2},
            new int[]{3,2,4,5},
            new int[]{3,2,4,5,9,11,10,8,7}
    );

    @Test
    public void longestConsecutive() {
        cases.forEach(c -> System.out.println(solution.longestConsecutive(c)));
    }
}