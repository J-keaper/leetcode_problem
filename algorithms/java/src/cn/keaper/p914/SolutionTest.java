package cn.keaper.p914;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,4,3,2,1},
            new int[]{1,1,1,2,2,2,3,3},
            new int[]{1},
            new int[]{1,1},
            new int[]{1,1,2,2,2,2}
    );

    @Test
    public void hasGroupsSizeX() {
        cases.forEach(c -> System.out.println(solution.hasGroupsSizeX(c)));

    }
}