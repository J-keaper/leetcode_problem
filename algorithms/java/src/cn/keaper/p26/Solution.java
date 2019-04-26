package cn.keaper.p26;

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

}
