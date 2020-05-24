package cn.keaper.p33;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {


    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l + 1 < r){
            int m = (l + r) >>> 1;
            if(nums[m] == target){
                return m;
            }
            if(nums[0] < nums[m]){ // [0,m) 是连续上升区间
                if(nums[0] <= target && target < nums[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{ // (m,r] 是连续上升区间
                if(nums[m] < target && target <= nums[r]){
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
        }
        return nums[l] == target ? l : nums[r] == target ? r : -1;
    }

}
