package cn.keaper.p509;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    @Test
    public void fib() {
        IntStream.rangeClosed(0,30).forEach(i -> System.out.println(solution.fib(i) + "\t" +  solution.fib1(i)));

    }
}