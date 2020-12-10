package cn.keaper.review.p167;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l <= r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                return new int[]{l + 1,r + 1};
            }
        }
        return null;
    }
}
