package cn.keaper.p34;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        return new int[]{searchRange(nums, target, true), searchRange(nums, target, false)};
    }

    /**
     * 最左边的位置和最右边的位置，区别只在于当中间元素等于target时如何取
     *
     * @param left 最左位置还是最右位置
     */
    private int searchRange(int[] nums, int target, boolean left) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r){
            int m = (l+r) >>> 1;
            if(nums[m] > target){
                r = m;
            }else if(nums[m] < target){
                l = m;
            }else {
                if(left){
                    r = m;
                }else {
                    l = m;
                }
            }
        }
        if(left){
            return nums[l] == target ? l : nums[r] == target ? r : -1;
        }else {
            return nums[r] == target ? r : nums[l] == target ? l : -1;
        }
    }
}
