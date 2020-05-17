package cn.keaper.p8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "",
            "-",
            "+",
            "     ",
            "   +  ",
            "   -  ",
            "   +234",
            "   -234",
            "   -23 4  ",
            "   +23 4  ",
            "   +23.4  ",
            "   +23+4  ",
            "   +2147483647",
            "   +2147483648",
            "   +21474836479",
            "   -2147483648",
            "   -2147483649",
            "   -2147483650"
    );

    @Test
    public void myAtoi() {
        cases.forEach(c -> System.out.println(solution.myAtoi(c)));

    }
}