package cn.keaper.p830;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "abbxxxxzyy",
            "abc",
            "abcdddeeeeaabbbcd",
            "aba",
            "aaa"

    );

    @Test
    public void largeGroupPositions() {
        cases.forEach(c -> System.out.println(solution.largeGroupPositions(c)));
    }
}