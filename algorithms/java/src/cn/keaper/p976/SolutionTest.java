package cn.keaper.p976;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,1,2},
            new int[]{1,2,1},
            new int[]{3,2,3,4},
            new int[]{3,6,3,2},
            new int[]{3,6,3,5,3,2,3,1},
            new int[]{3,6,3,2,2,3,4,5,6,7}
    );

    @Test
    public void largestPerimeter() {
        cases.forEach(c -> System.out.println(solution.largestPerimeter(c)));
    }
}