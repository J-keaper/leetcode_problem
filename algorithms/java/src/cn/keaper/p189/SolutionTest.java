package cn.keaper.p189;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private static Case[] cases = new Case[]{
            new Case(new int[]{1},1),
            new Case(new int[]{1},2),
            new Case(new int[]{1,2,3,4},1),
            new Case(new int[]{1,2,3,4},2),
            new Case(new int[]{1,2,3,4},3),
            new Case(new int[]{1,2,3,4},4),

            new Case(new int[]{1,2,3,4,5,6,7},1),
            new Case(new int[]{1,2,3,4,5,6,7},2),
            new Case(new int[]{1,2,3,4,5,6,7},3),
            new Case(new int[]{1,2,3,4,5,6,7},4),
            new Case(new int[]{1,2,3,4,5,6,7},5),
            new Case(new int[]{1,2,3,4,5,6,7},6),
            new Case(new int[]{1,2,3,4,5,6,7},7),
            new Case(new int[]{1,2,3,4,5,6,7},8),
            new Case(new int[]{1,2,3,4,5,6,7},14),
            new Case(new int[]{1,2,3,4,5,6,7},15),
            new Case(new int[]{-1,-100,3,99},2),
    };

    private Solution solution = new Solution();

    @Test
    public void rotate() {
        Arrays.asList(cases).forEach(c -> {
            solution.rotate(c.nums,c.k);
            System.out.println(Arrays.toString(c.nums));
        });
    }


    private static class Case{
        int [] nums;
        int k;
        public Case(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }
    }
}