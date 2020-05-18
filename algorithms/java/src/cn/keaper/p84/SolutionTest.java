package cn.keaper.p84;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2},
            new int[]{2,1},
            new int[]{2,1,3},
            new int[]{2,1,3,4},
            new int[]{2,1,5,6,2,3},
            new int[]{2,1,5,6,2,3,4,5,3,2,5,6,6,7,8,8,8,3,3,3,9,0,3,4,4,3}
    );


    @Test
    public void largestRectangleArea() {
        cases.forEach(c -> System.out.println(solution.largestRectangleArea(c)
                + " " + solution.largestRectangleArea2(c)));


    }
}