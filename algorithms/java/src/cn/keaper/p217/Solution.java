package cn.keaper.p217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class Solution {

    /**
     * manually implemented map
     * Notice : may occur OOM Exception
     * time: O(N)
     * space：O(N)
     */
    public boolean containsDuplicate(int[] nums){
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Integer.min(min,nums[i]);
            max = Integer.max(max,nums[i]);
        }
        boolean[] exist = new boolean[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            if(exist[nums[i] - min]){
                return true;
            }
            exist[nums[i] - min] = true;
        }
        return false;
    }

    /**
     * HashTable
     * time: O(N)
     * space：O(N)
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> exist = new HashSet<>(nums.length);
        for (int num : nums) {
            if(exist.contains(num)){
                return true;
            }
            exist.add(num);
        }
        return false;
    }

    /**
     * Sorting
     * time: O(NLogN)
     * space：O(1)
     */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }


}
