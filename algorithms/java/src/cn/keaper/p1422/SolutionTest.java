package cn.keaper.p1422;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "011101",
            "00111",
            "1111",
            "01111101"
    );

    @Test
    public void maxScore() {
        cases.forEach(c -> System.out.println(solution.maxScore(c)));
    }
}