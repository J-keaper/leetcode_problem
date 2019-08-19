package cn.keaper.p231;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPowerOfTwo() {
        IntStream.range(-10,100).forEach(i -> System.out.println(i + " -> " + solution.isPowerOfTwo(i)));
    }
}