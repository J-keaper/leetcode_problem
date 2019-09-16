package cn.keaper.p349;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case(new int[]{1,2,2,1},new int[]{2,2}),
            new Case(new int[]{4,9,5},new int[]{9,4,9,8,4})
    );

    private Solution solution = new Solution();

    @Test
    public void intersection() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.intersection(c.nums1, c.nums2))));
    }

    @Test
    public void intersection1() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.intersection1(c.nums1, c.nums2))));
    }

    private class Case{
        private int[] nums1;
        private int[] nums2;

        public Case(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }
    }

}