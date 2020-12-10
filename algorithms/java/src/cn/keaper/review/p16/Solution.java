package cn.keaper.review.p16;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                int diff = Math.abs(sum - target);
                if(closest > diff){
                    closest = diff;
                    res = sum;
                }
                if(sum > target){
                    r--;
                }else if(sum < target){
                    l++;
                }else {
                    return sum;
                }
            }

        }
        return res;
    }

}