package cn.keaper.p371;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void getSum() {
        for (int i = 0; i < 10; i++) {
            int a = new Random().nextInt();
            int b = new Random().nextInt();
            System.out.println(a + b == solution.getSum(a,b));
        }
    }
}