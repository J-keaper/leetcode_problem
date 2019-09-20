package cn.keaper.p387;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private List<String> cases = Arrays.asList(
            "leetcode",
            "loveleetcode",
            "abcadfbaegh",
            "abcdefghhgfedcba"
    );

    private Solution solution = new Solution();

    @Test
    public void firstUniqChar() {
        cases.forEach(c -> System.out.println(solution.firstUniqChar(c)));
    }
}