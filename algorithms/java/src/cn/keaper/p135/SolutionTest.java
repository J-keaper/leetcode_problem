package cn.keaper.p135;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{1},
            new int[]{1,3},
            new int[]{1,0,2},
            new int[]{1,2,2},
            new int[]{1,2,87,87,87,2,1}
    );

    @Test
    public void candy() {
        cases.forEach(c -> System.out.println(solution.candy1(c)));
    }
}