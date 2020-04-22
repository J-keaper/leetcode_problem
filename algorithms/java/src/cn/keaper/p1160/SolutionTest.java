package cn.keaper.p1160;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"cat","bt","hat","tree","atach"},
            new String[]{"hello","world","leetcode","welldonehoneyr"}

    );

    @Test
    public void countCharacters() {
        cases.forEach(c -> System.out.println(solution.countCharacters(
                Arrays.copyOf(c, c.length - 1), c[c.length - 1]
        )));
    }
}