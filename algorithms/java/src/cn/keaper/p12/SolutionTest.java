package cn.keaper.p12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private int[] cases = new int[]{
            58,
            1994,
    };

    @Test
    public void intToRoman() {
        IntStream.range(1,100).forEach(c -> System.out.println(c + " => " + solution.intToRoman(c)));
        Arrays.stream(cases).forEach(c -> System.out.println(c + " => " + solution.intToRoman(c)));
    }
}