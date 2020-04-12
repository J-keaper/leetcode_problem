package cn.keaper.p409;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "abccccdd",
            "",
            "a",
            "aa",
            "aaa",
            "bbbb",
            "abcde",
            "aab",
            "AaAb",
            "abcdabcdabcd"
    );

    @Test
    public void longestPalindrome() {
        cases.forEach(c -> System.out.println(solution.longestPalindrome(c)));
    }
}