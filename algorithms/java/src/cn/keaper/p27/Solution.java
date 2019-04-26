package cn.keaper.p27;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {
    /**
     * 删除元素比较多时移动次数较少
     * 删除元素比较少时移动次数较多
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0 ; i < nums.length ; i ++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 删除元素比较多时移动次数较多
     * 删除元素比较少时移动次数较少
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int end = nums.length;
        while (i < end){
            if(nums[i] == val){
                nums[i] = nums[--end];
            }else{
                i ++;
            }
        }
        return i;
    }
}
