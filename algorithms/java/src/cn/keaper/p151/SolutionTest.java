package cn.keaper.p151;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "  hello ",
            "the sky is blue",
            "hello world",
            "  hello world  ",
            "a good example",
            "  a   good example ",
            "a b c",
            "   a   b  c   "
    );

    @Test
    public void reverseWords() {
        cases.forEach(c -> System.out.println(solution.reverseWords(c)));
    }
}