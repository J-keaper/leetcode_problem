package cn.keaper.p10;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "aa",
            "a",
            "aa",
            "a*",
            "abcdeee",
            "a.*b..*de*.*"
    );


    @Test
    public void isMatch() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.isMatch(cases.get(i), cases.get(i+1)));
        }

    }


    @Test
    public void isMatch2() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.isMatch2(cases.get(i), cases.get(i+1)));
        }

    }

    @Test
    public void isMatch3() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.isMatch3(cases.get(i), cases.get(i+1)));
        }

    }
}