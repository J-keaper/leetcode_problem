package cn.keaper.p350;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case(new int[]{1,2,2,1},new int[]{2,2}),
            new Case(new int[]{4,9,5},new int[]{9,4,9,8,4}),
            new Case(new int[]{5,6,4,3,8,8,4,4,6,4,3},new int[]{8,9,8,7,1,2,3,4,2,5,1,2,5,1,2})
    );


    private Solution solution = new Solution();

    @Test
    public void intersect() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.intersect(c.nums1, c.nums2))));
    }
    @Test
    public void intersect1() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.intersect1(c.nums1, c.nums2))));
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