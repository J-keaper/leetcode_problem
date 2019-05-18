package cn.keaper.p167;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private Input[] cases = new Input[]{
            new Input(new int[]{2,7,11,15},9),
            new Input(new int[]{2,7,9,10},17),
            new Input(new int[]{2,7,9,10},16),
    };

    private Solution solution = new Solution();

    @Test
    public void twoSum() {
        Arrays.stream(cases).forEach(c -> System.out.println((Arrays.toString(solution.twoSum(c.numbers, c.target)))));
    }

    @Test
    public void twoSum1() {
        Arrays.stream(cases).forEach(c -> System.out.println((Arrays.toString(solution.twoSum1(c.numbers, c.target)))));
    }

    public static class Input{
        int[] numbers;
        int target;

        public Input(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
        }
    }
}