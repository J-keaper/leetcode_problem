package cn.keaper.p692;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2),
            new Case(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4),
            new Case(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1)
    );

    @Test
    public void topKFrequent() {
        cases.forEach(c -> System.out.println(solution.topKFrequent(c.words, c.k)));
    }


    static class Case{
        String[] words;
        int k;

        public Case(String[] words, int k) {
            this.words = words;
            this.k = k;
        }
    }
}