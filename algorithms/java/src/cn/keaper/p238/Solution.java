package cn.keaper.p238;


/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Solution {

    /**
     * 比较容易想到的办法是计算所有数的乘积，除以当前数，但题目规定不允许使用除法
     */


    /**
     * 计算两个数组，L，R，分别表示前缀乘积和后缀乘积
     * L = [1, a1 , a1*a2 , a1*a2*a3 , ... , a1*a2*...*an-2, a1*a2*...*an-2]
     * R = [a2*a3...*an , a3*a4*...an , a4*a5*...an , ... , an, 1]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length], right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = i == 0 ? 1 : left[i-1] * nums[i-1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = i == nums.length - 1 ? 1 : right[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }


    /**
     * 上面方法的改进，不需要占用额外的数组空间，只是用输出数组原地计算即可
     *
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = i == 0 ? 1 : res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= (right = right * nums[i+1]);
        }
        return res;
    }

}
