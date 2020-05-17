package cn.keaper.p65;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "0",
            " 0.1 ",
            "abc",
            "1 a",
            "2e10",
            " -90e3   ",
            " 1e",
            "e3",
            " 6e-1",
            " 99e2.5 ",
            "53.5e93",
            " --6 ",
            "-+3",
            "95a54e53"
    );


    @Test
    public void isNumber() {
        cases.forEach(c -> System.out.println("\"" + c + "\" => " + solution.isNumber(c)));

    }
}