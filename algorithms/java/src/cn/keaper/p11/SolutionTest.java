package cn.keaper.p11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<int[]> cases = Arrays.asList(
            new int[]{1,8,6,2,5,4,8,3,7},
            new int[]{1,3,4,5,6,7,4,8,6,2,5,4,8,3,7},
            new int[]{1,8,6,2,5,4,8,4,3,7,8,9,4,3,7}
    );


    @Test
    public void maxArea() {
        cases.forEach(c -> System.out.println(solution.maxArea(c)));
    }
}