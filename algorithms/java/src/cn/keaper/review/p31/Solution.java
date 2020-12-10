package cn.keaper.review.p31;


public class Solution {

    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]){
            k--;
        }
        if(k >= 0){
            int j = nums.length - 1;
            while (j > k  && nums[j] <= nums[k]){
                j--;
            }
            swap(nums, k, j);
        }


        int l = k + 1, r = nums.length - 1;
        while (l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}