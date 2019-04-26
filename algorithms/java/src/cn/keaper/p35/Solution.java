package cn.keaper.p35;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class Solution {

    /**
     * Liner Search
     * O(N)
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && target > nums[i]){
            i++;
        }
        return i;
    }

    /**
     * Binary Search
     * O(LogN)
     */
    public int searchInsert2(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] > target){
                r = m -1;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
}
