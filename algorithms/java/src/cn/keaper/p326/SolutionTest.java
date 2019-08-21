package cn.keaper.p326;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    @Test
    public void isPowerOfThree() {
        IntStream.range(-5,100).forEach(i -> System.out.println(i + " -> " + solution.isPowerOfThree(i)));
    }
}