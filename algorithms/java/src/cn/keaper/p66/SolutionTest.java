package cn.keaper.p66;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void plusOne() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{2,8,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,0,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }
}