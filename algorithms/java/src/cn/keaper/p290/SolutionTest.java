package cn.keaper.p290;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class SolutionTest {

    private List<String[]> cases = Arrays.asList(
            new String[]{"abba","dog cat cat dog"},
            new String[]{"abba","dog cat cat fish"},
            new String[]{"aaaa","dog cat cat dog"},
            new String[]{"abba","dog dog dog dog"},
            new String[]{"abbac","dog cat cat dog fish"}
    );


    private Solution solution = new Solution();

    @Test
    public void wordPattern() {
        cases.forEach(c -> System.out.println(solution.wordPattern(c[0],c[1])));

    }



}