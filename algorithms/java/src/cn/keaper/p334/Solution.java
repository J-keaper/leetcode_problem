package cn.keaper.p334;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Solution {


    /**
     * 两个变量 small 和 mid ，遍历数组，分别用来保存当前遇到的最小值和中间值
     * 如果遇到了大于mid的值则一定是有一个解的
     *
     * 思考这样一个问题，当已经找到了长度为 2 的递增序列，这时又来了一个比 small 还小的数字，为什么可以直接替换 small 呢
     * 这样 small 和 mid 在原数组中并不是按照索引递增的关系
     *
     * 但是其实我们已经知道，在这之前是有一个满足条件的small的，所以如果后面出现一个大于mid的值，那与上一个small值仍然是可以组成解的
     * 更新small的原因是我们可能在之后会有更优解
     *
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < small) {
                small = num;
            }
            if (small < num && num < mid) {
                mid = num;
            }
            if (num > mid) {
                return true;
            }
        }
        return false;
    }

}
