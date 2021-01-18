package cn.keaper.review.p179;

import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String number : numbers) {
            res.append(number);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10,2}));
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Solution().largestNumber(new int[]{1}));
        System.out.println(new Solution().largestNumber(new int[]{10}));
        System.out.println(new Solution().largestNumber(new int[]{0,1}));
        System.out.println(new Solution().largestNumber(new int[]{0,0}));
        System.out.println(new Solution().largestNumber(new int[]{0}));
    }
}
