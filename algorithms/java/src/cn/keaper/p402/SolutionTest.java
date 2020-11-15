package cn.keaper.p402;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case("123456654321", 1),
            new Case("123456654321", 2),
            new Case("1432219", 1),
            new Case("1432219", 2),
            new Case("1432219", 3),
            new Case("10200", 1),
            new Case("10", 1),
            new Case("10", 2)
    );



    @Test
    public void removeKdigits() {
        cases.forEach(c -> {
            System.out.println(solution.removeKdigits(c.num, c.k));
            System.out.println(solution.removeKdigits1(c.num, c.k));
            System.out.println();
        });
    }


    static class Case{
        String num;
        int k;

        public Case(String num, int k) {
            this.num = num;
            this.k = k;
        }
    }
}