package cn.keaper.p167;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution {

    /**
     * Time: O(N)
     */
    public int[] twoSum(int[] numbers, int target) {
        int s = 0 , e = numbers.length - 1;
        while (numbers[s] + numbers[e] != target){
            if(numbers[s] + numbers[e] > target){
                e --;
            }else {
                s ++;
            }
        }
        return new int[]{s + 1,e + 1};
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer,Integer> indexes = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(indexes.containsKey(target - numbers[i])){
                return new int[]{indexes.get(target - numbers[i]),i + 1};
            }
            indexes.put(numbers[i],i + 1);
        }
        return new int[]{};
    }

}
