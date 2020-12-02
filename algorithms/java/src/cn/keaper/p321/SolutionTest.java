package cn.keaper.p321;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private final Solution solution = new Solution();

    private final List<Case> cases = Arrays.asList(
            new Case(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5), // [9, 8, 6, 5, 3]
            new Case(new int[]{6, 7}, new int[]{6, 0, 4}, 5), // [6, 7, 6, 0, 4]
            new Case(new int[]{3, 9}, new int[]{8, 9}, 3), // [9, 8, 9]
            new Case(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15) // [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]

    );


    @Test
    public void maxNumber() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.maxNumber(c.nums1, c.nums2, c.k))));
    }


    static class Case {
        int[] nums1;
        int[] nums2;
        int k;

        public Case(int[] nums1, int[] nums2, int k) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.k = k;
        }
    }
}