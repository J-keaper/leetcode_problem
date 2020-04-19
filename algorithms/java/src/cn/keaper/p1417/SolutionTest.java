package cn.keaper.p1417;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "",
            "a0b1c2",
            "leetcode",
            "1229857369",
            "covid2019",
            "ab123"
    );

    @Test
    public void reformat() {
        cases.forEach(c -> System.out.println(solution.reformat(c)));

    }
}