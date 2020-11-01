package cn.keaper.p140;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"catsanddog", "cat", "cats", "and", "sand", "dog"},
            new String[]{"pineapplepenapple", "apple", "pen", "applepen", "pine", "pineapple"},
            new String[]{"catsandog", "cats", "dog", "sand", "and", "cat"},
            new String[]{"catsanddogdogcatsanddogsand", "cat", "cats", "and", "sand", "dog"},
            new String[]{"aaaaaaaaaaaaa", "a", "aa", "aaa", "aaaa", "aaaaa"}

    );

    @Test
    public void wordBreak() {
        cases.forEach(c -> {
            List<String> word = Arrays.asList(Arrays.copyOfRange(c, 1, c.length));
            List<String> res = solution.wordBreak(c[0], word);
            System.out.println(Arrays.toString(res.toArray(new String[]{})));
        });
    }
}