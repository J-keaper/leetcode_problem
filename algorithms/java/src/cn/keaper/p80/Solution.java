package cn.keaper.p80;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {

    /**
     * 比较当前元素与结果集中的倒数第二个元素
     * 如果不相等，则说明当前元素的个数小于2，将当前元素加入结果集
     * 如果相等，则说明当前元素的个数已经等于2，跳过当前元素
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int c = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[c - 2]){
                nums[c++] = nums[i];
            }
        }
        return c;
    }



    /**
     * 使用一个变量记录当前元素的重复次数，重复次数小于等于2时，则加入结果集
     */
    public int removeDuplicates1(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int c = 0, dup = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                dup ++;
            }else{
                dup = 1;
            }
            if(dup <= 2){
                nums[++c] = nums[i];
            }
        }
        return c + 1;
    }

}
