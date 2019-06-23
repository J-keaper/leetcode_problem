package cn.keaper.p171;

import org.junit.Test;

import java.util.Arrays;


public class SolutionTest {

    private String[] cases = new String[]{
            "A",
            "AB",
            "ZY"
    };

    private Solution solution = new Solution();


    @Test
    public void titleToNumber() {
        Arrays.asList(cases).forEach(c -> System.out.println(solution.titleToNumber(c)));
    }
}