package cn.keaper.p264;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void nthUglyNumber() {
        IntStream.range(1,50).forEach(i -> System.out.println(solution.nthUglyNumber(i)));
        System.out.println(solution.nthUglyNumber(1690));
    }
}