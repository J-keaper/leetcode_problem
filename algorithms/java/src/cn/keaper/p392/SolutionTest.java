package cn.keaper.p392;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case("",""),
            new Case("","q"),
            new Case("a",""),
            new Case("a","fdsa"),
            new Case("abc","ahbgdc"),
            new Case("axc","ahbgdc"),
            new Case("little","littlecat"),
            new Case("dog","dabcoabcgdsds"),
            new Case("leetcode","lyyeyyeyytyycyyyoydyey"),
            new Case("leetcode","lyyeyyeyytyycyyy")
    );

    private Solution solution = new Solution();

    @Test
    public void isSubsequence() {
        cases.forEach(c -> System.out.println(solution.isSubsequence(c.s,c.t)));
    }


    private class Case {
        String s;
        String t;

        public Case(String s, String t) {
            this.s = s;
            this.t = t;
        }
    }


}