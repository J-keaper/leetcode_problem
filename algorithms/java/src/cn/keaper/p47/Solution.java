package cn.keaper.p47;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Solution {



    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        dfs(res, nums.length, 0, output);
        return new ArrayList<>(res);
    }

    /**
     * 与 P46 解法一致，最后结果使用Set去重即可
     * @see cn.keaper.p46.Solution
     *
     */
    private void dfs(Set<List<Integer>> res, int length, int depth, List<Integer> nums){
        if(depth == length){
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = depth; i < length; i++) {
            if(depth != i && nums.get(depth).equals(nums.get(i))){
                continue;
            }
            Collections.swap(nums, depth, i);
            dfs(res, length, depth + 1, nums);
            Collections.swap(nums, depth, i);
        }
    }

}
