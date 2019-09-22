package cn.keaper.p389;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
        new Case("","a"),
        new Case("dcba","abecd"),
        new Case("abcdefghtij","cdfgabhzteij")
    );

    private Solution solution = new Solution();

    @Test
    public void findTheDifference() {
        cases.forEach(c -> System.out.println(solution.findTheDifference(c.s,c.t)));
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