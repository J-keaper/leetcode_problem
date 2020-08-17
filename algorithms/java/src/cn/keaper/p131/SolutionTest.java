package cn.keaper.p131;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "aab",
            "aabcdaba"
    );

    @Test
    public void partition() {
        cases.forEach(c -> {
            System.out.println(solution.partition(c));
            System.out.println(solution.partition1(c));
        });

    }
}