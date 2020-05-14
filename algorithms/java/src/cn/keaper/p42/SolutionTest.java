package cn.keaper.p42;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
            new int[]{0,1,0,2,1,0,1,3,2}
    );

    @Test
    public void trap() {
        cases.forEach(c -> System.out.println(solution.trap(c)));

    }
}