package cn.keaper.p139;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"leetcode", "leet", "code"},
            new String[]{"applepenapple", "apple", "pen"},
            new String[]{"catsandog", "cats", "dog", "sand", "and", "cat"},
            new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab","a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}
    );

    @Test
    public void wordBreak() {
        cases.forEach(c -> {
            String word = c[0];
            List<String> wordDict = Arrays.asList(Arrays.copyOfRange(c, 1, c.length));
            System.out.print(solution.wordBreak(word, wordDict));
            System.out.print("\t");
            System.out.println(solution.wordBreak1(word, wordDict));
        });
    }
}