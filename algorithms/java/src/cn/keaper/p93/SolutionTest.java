package cn.keaper.p93;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "25525511135",
            "010010"
    );

    @Test
    public void restoreIpAddresses() {
        cases.forEach(c -> {
            List<String> res = solution.restoreIpAddresses(c);
            res.forEach(System.out::println);
            System.out.println();
        });
    }

    @Test
    public void restoreIpAddresses2() {
        cases.forEach(c -> {
            List<String> res = solution.restoreIpAddresses2(c);
            res.forEach(System.out::println);
            System.out.println();
        });
    }
}