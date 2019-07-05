package cn.keaper.p191;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private String[] cases = new String[]{
            "00000000000000000000000000001011",
            "00000000000000000000000010000000",
            "11111111111111111111111111111101"
    };

    private Solution solution = new Solution();

    @Test
    public void hammingWeight() {
        Arrays.asList(cases).forEach(c -> System.out.println(solution.hammingWeight(Integer.parseUnsignedInt(c,2))));
    }

    @Test
    public void hammingWeight2() {
        Arrays.asList(cases).forEach(c -> System.out.println(solution.hammingWeight2(Integer.parseUnsignedInt(c,2))));
    }

    @Test
    public void hammingWeight1() {
        Arrays.asList(cases).forEach(c -> System.out.println(solution.hammingWeight1(Integer.parseUnsignedInt(c,2))));
    }
}