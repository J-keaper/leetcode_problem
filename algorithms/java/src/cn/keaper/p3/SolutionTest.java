package cn.keaper.p3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "a",
            "ab",
            "abcabcbb",
            "bbbbb",
            "pwwkew"
    );

    @Test
    public void lengthOfLongestSubstring() {
        cases.forEach(c -> System.out.println(solution.lengthOfLongestSubstring(c)));
    }
}