package cn.keaper.p820;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"time"},
            new String[]{"time", "me"},
            new String[]{"time", "ab"},
            new String[]{"time", "me", "bell"},
            new String[]{"time", "abc", "bell"},
            new String[]{"time", "e", "bell","ll","ac"}
    );

    @Test
    public void minimumLengthEncoding() {
        cases.forEach(c -> System.out.println(solution.minimumLengthEncoding(c)));

    }
}