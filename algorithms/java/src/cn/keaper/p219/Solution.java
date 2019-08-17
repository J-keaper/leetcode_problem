package cn.keaper.p219;

import java.util.*;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class Solution {

    /**
     * maintain a continuous subset of {nums} with size {k}
     * if exist repeating element,return true
     * time: O(N)
     * space: O(K) worst O(N)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> exist = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if(i - k > 0){
                exist.remove(nums[i - k - 1]);
            }
            if(!exist.add(nums[i])){
                return true;
            }
        }
        return false;
    }


    /**
     * time: O(N*K) worst O(N^2)
     * space: O(1)
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1 ; j <= i + k && j < nums.length; j ++){
                System.out.println("one iterate");
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * time: O(NLogN)
     * space: O(N)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Integer[] indexes = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(o -> nums[o]));
        for (int i = 1; i < indexes.length; i++) {
            if(nums[indexes[i]] == nums[indexes[i - 1]] && Math.abs(indexes[i] - indexes[i - 1]) <= k){
                return true;
            }
        }
        return false;
    }

    /**
     * time：O(N)
     * space：O(N)
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer,Integer> pos = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(pos.containsKey(nums[i]) && i - pos.get(nums[i]) <= k){
                return true;
            }
            pos.put(nums[i],i);
        }
        return false;
    }
}
