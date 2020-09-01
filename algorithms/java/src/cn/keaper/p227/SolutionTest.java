package cn.keaper.p227;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "1-1+1",
            "1",
            "3+2*2",
            " 3 / 2 ",
            " 3 + 5 / 2 ",
            "  3 + 2*    5   + 8 - 6 * 2 ",
            "  13 + 223*    325   + 28 - 26 * 22 ",
            "  31 + 22*    52   + 80 - 6 * 10 ",
            "  31 + 2 2*    5 2   + 80 - 6 * 10"

    );

    @Test
    public void calculate() {
        cases.forEach(c -> System.out.println(solution.calculate(c)));
    }


    @Test
    public void calculate1() {
        cases.forEach(c -> System.out.println(solution.calculate1(c)));
    }
}