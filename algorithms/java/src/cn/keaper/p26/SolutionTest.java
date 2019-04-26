package cn.keaper.p26;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void removeDuplicates() {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2,3,3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}