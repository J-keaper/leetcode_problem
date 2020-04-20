package cn.keaper.p1071;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"ABCABC","ABC"},
            new String[]{"ABABAB","AB"},
            new String[]{"LEFT","CODE"},
            new String[]{"AB","A"},
            new String[]{"AA","AAA"},
            new String[]{"AAAA","AAA"}
    );
    @Test
    public void gcdOfStrings() {
        cases.forEach(c -> System.out.println(solution.gcdOfStrings(c[0], c[1])));

    }
}