package cn.keaper.p1;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void twoSum() {
        int [] nums = new int[]{2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}