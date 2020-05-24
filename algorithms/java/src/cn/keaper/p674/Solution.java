package cn.keaper.p674;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int len = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] > nums[i-1]){
                len++;
            }else {
                maxLen = Math.max(len, maxLen);
                len = 1;
            }
        }
        maxLen = Math.max(len, maxLen);
        return maxLen;
    }

}
