package cn.keaper.p1370;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    private final List<String> cases = Arrays.asList(
            "aaaabbcc",
            "aaaabbbbbccc",
            "aaaabbbcccc",
            "rat",
            "leetcode",
            "ggggggg",
            "spo"
    );


    @Test
    public void sortString() {
        cases.forEach(c -> System.out.println(solution.sortString(c)));
    }
}