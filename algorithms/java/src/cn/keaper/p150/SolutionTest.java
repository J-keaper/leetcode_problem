package cn.keaper.p150;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"2", "1", "+", "3", "*"},
            new String[]{"4", "13", "5", "/", "+"},
            new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
    );

    @Test
    public void evalRPN() {
        cases.forEach(c -> System.out.println(solution.evalRPN(c)));
    }
}