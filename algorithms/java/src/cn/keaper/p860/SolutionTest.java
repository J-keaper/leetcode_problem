package cn.keaper.p860;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{5,5,5,10,20},
            new int[]{5,5,10},
            new int[]{10,10},
            new int[]{5,5,10,10,20},
            new int[]{5,5,5,5,10,20,10}
    );

    @Test
    public void lemonadeChange() {
        cases.forEach(c -> System.out.println(solution.lemonadeChange(c)));
    }
}