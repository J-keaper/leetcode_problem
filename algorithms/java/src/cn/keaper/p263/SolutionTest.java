package cn.keaper.p263;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private List<Integer> cases = Arrays.asList(
            -12,0,1,2,3,4,5,6,8,10,12,14,44,45,47,49,68,99,101,2147483647
    );

    private Solution solution = new Solution();

    @Test
    public void isUgly() {
        cases.forEach(c -> System.out.println(c + " -> " + solution.isUgly(c)));
    }
}