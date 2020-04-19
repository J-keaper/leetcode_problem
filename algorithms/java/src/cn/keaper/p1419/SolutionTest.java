package cn.keaper.p1419;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
           "croakcroak",
            "crcoakroak",
            "crcoakroakcroakcroakcrcoakroak",
            "ccrrooaakkcroakccrrooaakk",
            "ccrrooaakkcroakcccrrroooaaakkk",
            "croakcrook",
            "croakcroa",
            "aoocrrackk"

    );

    @Test
    public void minNumberOfFrogs() {
        cases.forEach(c -> System.out.println(solution.minNumberOfFrogs(c)));

    }
}