package cn.keaper.p17;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private String[] cases = new String[]{
            "",
            "2",
            "3",
            "23",
            "34",
            "89",
            "234",
            "453",
            "689",

    };

    @Test
    public void letterCombinations() {
        for (String aCase : cases) {
            System.out.println(solution.letterCombinations(aCase));
        }
    }
}