package cn.keaper.p204;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void countPrimes() {
        IntStream.range(0,100).forEach(c -> System.out.println(c + " -> " + solution.countPrimes(c)));
    }
}