package cn.keaper.p268;

public class Solution {


    /**
     * [0,1,3,4]
     * missing = 4^(0^0)^(1^1)^(2^3)^(3^4)
     * =(4^4)^(0^0)^(1^1)^(3^3)^2
     * =0^0^0^0^2
     * =2
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    /**
     * The sum of [0, 1, 2, ..., n] is n*(n+1)/2, it minus the sum of input is missing value.
     */
    public int missingNumber1(int[] nums) {
        int sum = (nums.length * (1 + nums.length)) >> 1;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}
