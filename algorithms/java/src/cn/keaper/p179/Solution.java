package cn.keaper.p179;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class Solution {

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        // 最重要的比较方法
        Arrays.sort(numStr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if(numStr[0].equals("0")){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String str : numStr) {
            res.append(str);
        }
        return res.toString();
    }

}
