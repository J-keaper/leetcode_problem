package cn.keaper.review.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int start, int target, int k){
        if(k == 2){
            return twoSum(nums, start, target);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(start + k > nums.length || target < nums[start] * k || target > nums[nums.length - 1] * k){
            return res;
        }
        for (int i = start; i < nums.length; i++) {
            if(i == start || nums[i] != nums[i-1]){
                for (List<Integer> list : kSum(nums, i + 1, target - nums[i], k - 1)) {
                    list.add(0, nums[i]);
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


    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        System.out.println(res);
    }
}
