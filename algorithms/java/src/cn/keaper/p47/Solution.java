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


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(res, nums, new boolean[nums.length], new ArrayList<>(), 0);
        return res;
    }


    /**
     * 使用used数组来表示对应位置的元素是否已经被使用
     *
     * 去重逻辑：对于待选的相同数字，只选第一个
     *
     */
    private void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> output, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            output.add(nums[i]);
            dfs(res, nums, used, output, depth + 1);
            output.remove(output.size() - 1);
            used[i] = false;
        }
    }


}
