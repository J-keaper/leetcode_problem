package cn.keaper.p32;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "",
            "(",
            ")",
            "()()()()))((()))()()",
            "((()()()(()))(((())))))((())()()",
            "()()()()()(())(())()))))))((((((((",
            "())()()())()())(((()))((())))((((",
            "()(()",
            "(()",
            ")()())"
    );

    @Test
    public void longestValidParentheses() {
        cases.forEach(c -> System.out.println(solution.longestValidParentheses(c)));
    }
}