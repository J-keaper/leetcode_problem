package cn.keaper.p680;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "aba",
            "aabaa",
            "aaaaa",
            "abcddcba",
            "abcddcsba",
            "abcdsdcba",
            "abcdsdcsba",
            "abcdsdcsbas"
    );

    @Test
    public void validPalindrome() {
        cases.forEach(c -> System.out.println(solution.validPalindrome(c)));
    }
}