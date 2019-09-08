package cn.keaper.p344;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<String> cases = Arrays.asList(
            "hello",
            "Hannah",
            "abcedfg"
    );

    private Solution solution = new Solution();

    @Test
    public void reverseString() {
        cases.forEach(c -> {
            char [] chars = c.toCharArray();
            solution.reverseString(chars);
            System.out.println(chars);
        });
    }
}