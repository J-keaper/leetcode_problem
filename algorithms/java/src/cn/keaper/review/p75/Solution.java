package cn.keaper.review.p75;

import java.util.Arrays;

public class Solution {


    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2;) {
            if(nums[i] == 0){
                if(i == p0){
                    i++;
                }else{
                    swap(nums, i, p0);
                }
                p0++;
            }else if (nums[i] == 2){
                swap(nums, i, p2);
                p2--;
            }else{
                i++;
            }
        }
    }


    private void swap(int[] nums, int i, int j){
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        new Solution().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}

