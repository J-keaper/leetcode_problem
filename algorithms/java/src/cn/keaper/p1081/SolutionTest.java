package cn.keaper.p1081;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {



    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "bcabc",
            "cbacdcbc"
    );

    @Test
    public void smallestSubsequence() {
        cases.forEach(c -> System.out.println(solution.smallestSubsequence(c)));
    }

}