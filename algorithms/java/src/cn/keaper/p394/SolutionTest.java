package cn.keaper.p394;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "3[a]2[bc]",
            "3[a2[c]]",
            "2[abc]3[cd]ef",
            "abc3[cd]xyz"
    );

    @Test
    public void decodeString() {
        cases.forEach(c -> System.out.println(solution.decodeString(c)));
    }
}