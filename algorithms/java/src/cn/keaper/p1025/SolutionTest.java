package cn.keaper.p1025;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void divisorGame() {
        IntStream.range(2,10).forEach(i -> System.out.println(solution.divisorGame(i)));
    }
}