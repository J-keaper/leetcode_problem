package cn.keaper.p31;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class Solution {

    /**
     * https://zh.wikipedia.org/wiki/%E5%85%A8%E6%8E%92%E5%88%97%E7%94%9F%E6%88%90%E7%AE%97%E6%B3%95
     * 设P是集合{1，2，……n-1，n}的一个全排列：P=P1P2……Pj-1PjPj+1……Pn（1≤P1，P2，……，Pn≤n-1）
     *
     * 1. 从排列的右端开始，找出第一个比右边数字小的数字的序号j，即j=max{i|Pi<Pi+1，i>j}
     * 2. 在Pj的右边的数字中，找出所有比Pj大的数字中最小的数字Pk，即k=min{i|Pi>Pj，i>j}
     * 3. 交换Pj，Pk
     * 4. 再将排列右端的递减部分Pj+1Pj+2……Pn倒转，因为j右端的数字是降序，所以只需要其左边和右边的交换，直到中间，因此可以得到一个新的排列P'=P1P2……Pj-1PkPn……Pj+2Pj+1。
     *
     */
    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if(k >= 0){
            for (int i = nums.length - 1; i > k; i--) {
                if(nums[i] > nums[k]){
                    swap(nums, i, k);
                    break;
                }
            }
        }
        for (int l = k + 1, r = nums.length - 1; l < r ; l++, r--) {
            swap(nums, l, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
