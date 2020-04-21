package cn.keaper.p1103;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{7,4},
            new int[]{10,3},
            new int[]{1000000000,1000}
    );

    @Test
    public void distributeCandies() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.distributeCandies(c[0], c[1]))));

    }
}