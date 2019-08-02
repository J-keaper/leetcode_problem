package cn.keaper.p202;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isHappy() {
        IntStream.range(1145,1200).forEach(i -> {
            System.out.println(i + "==>" + solution.isHappy(i));
            System.out.println("=============================");
        });
    }
}