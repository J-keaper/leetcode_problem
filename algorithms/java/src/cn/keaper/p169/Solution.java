package cn.keaper.p169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/majority-element/
 */
public class Solution {
    /**
     * Boyer–Moore majority vote algorithm
     * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     * space: O(1)
     * time: O(N)
     */
    public int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int num : nums) {
            if(count == 0){
                major = num;
            }
            count += num == major ? 1 : -1;
        }
        return major;
    }


    /**
     * use map to store count of every number
     * space: O(N)
     * time: O(N)
     */
    public int majorityElement1(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if(countMap.containsKey(num)){
                countMap.put(num,countMap.get(num) + 1);
            }else {
                countMap.put(num,1);
            }
            if(countMap.get(num) > nums.length / 2){
                return num;
            }
        }
        throw new IllegalArgumentException("no result");
    }


    /**
     * sort,get middle element
     * space: O(1)
     * time: O(N*LogN)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }




}
