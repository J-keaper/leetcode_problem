package cn.keaper.p128;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class Solution {


    /**
     * 使用HashSet存储出现的所有数字，遍历每个数字，
     * 判断小于自身的数和大于自身的数是否存在，一直向左右扩张，直到不连续为止，记录最大长度
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> exist = new HashSet<>();
        for (int num : nums) {
            exist.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            int len = 1;
            for (int i = num + 1; exist.contains(i); i++){
                exist.remove(i);
                len ++;
            }
            for (int i = num - 1; exist.contains(i); i--){
                exist.remove(i);
                len ++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }


    /**
     * Time: O(N*LogN)
     * 排序之后，一次遍历判断连续的最大长度
     */
    public int longestConsecutive1(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Arrays.sort(nums);
        int len = 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == nums[i-1] + 1){
                len ++;
            }else {
                res = Math.max(res, len);
                len = 1;
            }
        }
        return Math.max(res, len);
    }

}
