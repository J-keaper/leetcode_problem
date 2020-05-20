package cn.keaper.p55;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,3,1,1,4},
            new int[]{3,2,1,0,4}
    );

    @Test
    public void canJump() {
        cases.forEach(c -> System.out.println(solution.canJump(c)));
    }
}