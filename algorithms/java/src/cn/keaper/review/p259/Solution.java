package cn.keaper.review.p259;

import java.util.Arrays;

public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum < target){
                    res += (r - l);
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }

}
