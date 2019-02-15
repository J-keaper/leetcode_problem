package cn.keaper.p1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int [] nums = new int[]{2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}
