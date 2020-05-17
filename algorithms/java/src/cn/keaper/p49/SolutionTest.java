package cn.keaper.p49;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution  = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
            new String[]{}
    );

    @Test
    public void groupAnagrams() {
        cases.forEach(c -> {
            List<List<String>> res = solution.groupAnagrams(c);
            res.forEach(g -> {
                g.forEach(System.out::println);
                System.out.println("--------");
            });
            System.out.println("===============");
        });
    }
}