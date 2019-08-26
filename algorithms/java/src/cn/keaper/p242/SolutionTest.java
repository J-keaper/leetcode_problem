package cn.keaper.p242;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<String[]> cases = Arrays.asList(
            new String[]{"anagram","nagaram"},
            new String[]{"anagram","naragam"},
            new String[]{"raanagm","nagaram"},
            new String[]{"abcd","dbca"},
            new String[]{"rat","car"}
    );

    private Solution solution = new Solution();

    @Test
    public void isAnagram() {
        cases.forEach(c -> System.out.println(solution.isAnagram(c[0],c[1])));
    }
}