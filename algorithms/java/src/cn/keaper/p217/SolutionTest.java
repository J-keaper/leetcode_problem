package cn.keaper.p217;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,1},
            new int[]{1,2,3,4},
            new int[]{1,1,1,3,3,4,3,2,4,2}
    );

    private Solution solution = new Solution();

    @Test
    public void containsDuplicate() {
        cases.forEach(c -> System.out.println(solution.containsDuplicate(c)));
    }
}