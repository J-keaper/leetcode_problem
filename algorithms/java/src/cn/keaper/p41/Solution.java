package cn.keaper.p41;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Solution {

    /**
     * 假设数组长度为N，那么可能的结果为1～N+1
     * 从小到大对于每个数都从数组中查找一遍，不存在则返回
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }
        return nums.length + 1;
    }

    /**
     * 假设数组长度为N，那么可能的结果为1～N+1
     * 从小到大查找一遍，不存在则返回，使用Set提前将数存起来可以在O(1)时间判断是否存在
     */
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length + 1;
    }


    /**
     * 对于1～N范围内的元素k，通过交换将其放置到下标为k的位置
     * 当对所有元素都处理完之后，如果某个元素1～N范围内某个数m不存在，那么m-1下标处的元素一定不等于m
     * 即可找到结果
     */
    public int firstMissingPositive2(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < nums.length; ) {
            if(nums[i] >= 1 && nums[i] <= l && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return l + 1;
    }


}
