package cn.keaper.p27;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void removeElement() {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};
        int val = 2;
        System.out.println(solution.removeElement(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void removeElement2() {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};
        int val = 2;
        System.out.println(solution.removeElement2(nums,val));
        System.out.println(Arrays.toString(nums));
    }
}