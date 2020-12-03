package cn.keaper.p204;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void countPrimes() {
        IntStream.range(0,100).forEach(c -> {
            System.out.print(c + " -> ");
            System.out.print(solution.countPrimes(c) + "\t");
            System.out.print(solution.countPrimes1(c) + "\t");
            System.out.print(solution.countPrimes2(c) + "\t");
            System.out.print(solution.countPrimes3(c) + "\t");
            System.out.println();
        });
    }
}