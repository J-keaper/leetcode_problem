package cn.keaper.p79;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<String[]> cases = Arrays.asList(
            new String[]{"ABCE","SFCS","ADEE", "ABCCED"},
            new String[]{"ABCE","SFCS","ADEE", "SEE"},
            new String[]{"ABCE","SFCS","ADEE", "ABCB"},
            new String[]{"ABCE","SFCS","ADEE","SDFS", "ABFDEE"}
    );

    @Test
    public void exist() {
        cases.forEach(c -> {
            char[][] arg = Arrays.stream(Arrays.copyOf(c, c.length - 1))
                    .map(String::toCharArray).toArray(char[][]::new);
            System.out.println(solution.exist(arg, c[c.length-1]));
        });

    }
}