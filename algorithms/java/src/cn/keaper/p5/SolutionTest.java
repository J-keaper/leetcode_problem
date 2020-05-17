package cn.keaper.p5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "",
            "babad",
            "cbbd"
    );

    @Test
    public void longestPalindrome() {
        cases.forEach(c -> System.out.println(solution.longestPalindrome(c)));
    }

    @Test
    public void longestPalindrome1() {
        cases.forEach(c -> System.out.println(solution.longestPalindrome1(c)));
    }
}