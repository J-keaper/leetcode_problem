package cn.keaper.p374;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void guessNumber() {
        for (int i = 0; i < 10; i++) {
            int target = new Random().nextInt(100);
            solution.setTarget(target);
            System.out.println(solution.guessNumber(100) == solution.getTarget());
        }

    }
}