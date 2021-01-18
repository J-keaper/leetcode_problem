package cn.keaper.review.p34;

import javafx.util.Pair;

import java.util.Arrays;

public class Solution {


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    public int search(int[] nums, int target, boolean left){
        int l = 0, r = nums.length - 1;
        while (l + 1 < r){
            int m = (l + r) >>> 1;
            if(nums[m] < target){
                l = m;
            }else if (nums[m] > target){
                r = m;
            }else {
                if(left) {
                    r = m;
                }else{
                    l = m;
                }
            }
        }
        if(left){
            return nums[l] == target ? l : nums[r] == target ? r : -1;
        }else{
            return nums[r] == target ? r : nums[l] == target ? l : -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 5)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 10)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,8,9,10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1}, 0)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1}, 1)));
    }

}
