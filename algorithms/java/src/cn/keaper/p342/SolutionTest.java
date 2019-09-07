package cn.keaper.p342;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    @Test
    public void isPowerOfFour() {
        IntStream.range(0,1000).forEach(i -> {
            if(solution.isPowerOfFour(i)){
                System.out.println(i);
            }
        });

    }
}