package cn.keaper.p96;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    @Test
    public void numTrees() {
        IntStream.rangeClosed(1,10).forEach(i -> {
            System.out.println(solution.numTrees(i));
            System.out.println(solution.numTrees1(i));
            System.out.println();
        });
    }
}