package cn.keaper.p704;


/**
 * https://leetcode.com/problems/binary-search/
 */
public class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) >>> 1;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] > target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = (l + r) >>> 1;
            if(nums[m] < target){
                l = m + 1;
            }else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
