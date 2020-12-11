package cn.keaper.review.p334;

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num < first){
                first = num;
            }else if(num > first && num < second){
                second = num;
            }else if(num > second){
                return true;
            }
        }
        return false;
    }
}
