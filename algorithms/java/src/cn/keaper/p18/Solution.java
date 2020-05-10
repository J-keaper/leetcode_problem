package cn.keaper.p18;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 */
public class Solution {

    /**
     *
     * 与三数之和一样的思想，先存储两个数之和的下标，然后遍历另外两个数
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> posMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                posMap.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>());
                posMap.get(nums[i] + nums[j]).add(new int[]{i,j});
            }
        }

        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int t = target - nums[i] - nums[j];
                List<int[]> posList = posMap.get(t);
                if(posList == null){
                    continue;
                }
                for (int[] indexes : posList) {
                    if(indexes[0] <= j){
                        continue;
                    }
                    Integer[] oneRes = new Integer[]{nums[i], nums[j], nums[indexes[0]], nums[indexes[1]]};
                    Arrays.sort(oneRes);
                    List<Integer> oneSolution = Arrays.asList(oneRes);
                    if(!res.contains(oneSolution)){
                        res.add(oneSolution);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }


}
