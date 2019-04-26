package cn.keaper.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i ++){
            int diff = target - nums[i];
            if(indexMap.containsKey(diff)){
                return new int[]{indexMap.get(diff),i};
            }
            indexMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Solution");
    }
}