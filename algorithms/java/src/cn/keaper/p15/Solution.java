package cn.keaper.p15;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

    /**
     * Time：O(N^2)，但实际复杂度要小于O(N^2)，因为夹逼过程可以很快退出
     * 先进行排序，进行n-2次遍历，对其右边的数字进行夹逼
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i -1]) continue;  // 去重
            int l = i + 1, r = nums.length - 1, target = -nums[i];
            while (l < r){
                if(nums[l] + nums[r] > target) r--;
                else if(nums[l] + nums[r] < target) l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++; // 去重
                    while (l < r && nums[r] == nums[r-1]) r--; // 去重
                    l++;
                    r--;
                }
            }
        }
        return res;
    }

    /**
     * 结果：Time Limit Exceeded
     * time: O(N^2)
     * 类似Two Sum，存储每个元素的下标，固定一个元素，就相当于Two Sum
     * 因为需要去重复，所以需要对结果集中的结果排序，并且维护HashSet，实际开销比较大
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer index = indexMap.get(-nums[i] - nums[j]);
                if(index != null && index > i && index > j){
                    Integer[] r = new Integer[]{nums[i], nums[j], -nums[i] - nums[j]};
                    Arrays.sort(r);
                    res.add(Arrays.asList(r));
                }
            }
        }
        return new ArrayList<>(res);
    }

}
