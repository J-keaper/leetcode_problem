package cn.keaper.p75;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class Solution {

    /**
     * 使用两个指针，p0 指向左边0的最右边界(不包括)，p2 指向右边2的最左边界(不包括)
     * 然后使用cur指针遍历数组
     * 如果当前元素是0，那么交换 p0位置 与 cur位置 的元素，并且将p0位置右移
     * 如果当前元素是2，那么交换 p2位置 与 cur位置 的元素，并且将p2位置左移
     * 如果当前元素是1，那么继续下一元素，cur右移
     */
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2){
            if(nums[cur] == 0){
                if(cur == p0){
                    cur++; // 这里如果是原位置的话，直接向前移动
                }else {
                    swap(nums, p0, cur);
                }
                p0++;
            }else if(nums[cur] == 2){
                swap(nums, cur, p2);
                p2--;
            }else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
