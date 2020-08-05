package cn.keaper.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Solution {

    /**
     * 求解一个数组的幂集
     * 对于任意一个元素，都可以 选取 或者 不选取，所以最终结果会有 2^N 个
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        subsets(res, solution, nums,0);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> solution, int[] nums, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(solution));
            return;
        }
        subsets(res, solution, nums, depth + 1);

        solution.add(nums[depth]);
        subsets(res, solution, nums, depth + 1);
        solution.remove(solution.size() - 1);
    }

}
