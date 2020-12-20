package cn.keaper.p316;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "bcabc",
            "cbacdcbc",
            "cbacdcbcdbace",
            "cbacdcdbcdddbace"
    );

    @Test
    public void removeDuplicateLetters() {
        cases.forEach(c -> {
            System.out.println(solution.removeDuplicateLetters(c));
            System.out.println(solution.removeDuplicateLetters1(c));

        });
    }
}