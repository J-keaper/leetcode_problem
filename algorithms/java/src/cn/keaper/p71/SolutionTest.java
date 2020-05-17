package cn.keaper.p71;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/",
            "/a/../../b/../c//.//",
            "/a//b////c/d//././/.."
    );

    @Test
    public void simplifyPath() {
        cases.forEach(c -> System.out.println(solution.simplifyPath(c)));
    }
}