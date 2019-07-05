package cn.keaper.p190;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private String[] cases  = new String[]{
            "00000010100101000001111010011100",
            "11111111111111111111111111111101"
    };

    private Solution solution = new Solution();

    @Test
    public void reverseBits() {
        Arrays.asList(cases).forEach(c -> System.out.println(Integer.toBinaryString(solution.reverseBits(Integer.parseUnsignedInt(c,2)))));
    }

}