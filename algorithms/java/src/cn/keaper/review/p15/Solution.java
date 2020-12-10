package cn.keaper.review.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                for (List<Integer> list : twoSum(nums, i + 1, -nums[i])) {
                    list.add(0,nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;
        while (l < r){
            int sum = nums[l] + nums[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                res.add(new ArrayList<>(Arrays.asList(nums[l++], nums[r--])));
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
        }
        return res;
    }

}