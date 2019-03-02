package cn.keaper.p26;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int num = 0;
        for (int i = 1 ; i < nums.length ; i++) {
            if(nums[i] != nums[i-1]){
                nums[++num] = nums[i];
            }
        }
        return num + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2,3,3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
