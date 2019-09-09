package cn.keaper.p345;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<String> cases = Arrays.asList(
            "hello","leetcode","e","adse"
    );


    private Solution solution = new Solution();

    @Test
    public void reverseVowels() {
        cases.forEach(c -> System.out.println(solution.reverseVowels(c)));
    }
}