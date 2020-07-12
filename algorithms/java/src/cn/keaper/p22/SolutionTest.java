package cn.keaper.p22;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    @Test
    public void generateParenthesis() {
        IntStream.range(0,10).forEach(i ->
                System.out.println(solution.generateParenthesis(i)));
    }
}