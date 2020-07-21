package cn.keaper.p46;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        dfs(new LinkedList<>(), Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new)));
        return res;
    }

    /**
     * 遍历rest中的每个可选数字，添加到part的右边
     * 注意递归后需要状态重置
     *
     * @param part 表示已经确定的左半部分数字
     * @param rest 表示剩余可选的数字
     *
     * 用两个列表来维护的方式在进行状态转换及状态重置时操作比较耗时
     */
    private void dfs(List<Integer> part, List<Integer> rest){
        if(rest.isEmpty()){
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            part.add(rest.remove(i));
            dfs(part, rest);
            rest.add(i, part.remove(part.size() - 1));
        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        res = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        dfs(nums.length, 0, output);
        return res;
    }

    /**
     * 这里我们只用一个列表来做状态转换，列表初始值为数组原值
     * 在每一次递归中，从当前确定的长度之后依次与当前位置交换
     *
     * 交换的方式来进行状态转换和重置可以在O(1)时间内完成
     *
     * @param length 数组长度
     * @param depth 递归深度，等于已经确定的结果长度
     * @param nums 用作状态转换的列表
     */
    private void dfs(int length, int depth, List<Integer> nums){
        if(depth == length){
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = depth; i < length; i++) {
            Collections.swap(nums, depth, i);
            dfs(length, depth + 1, nums);
            Collections.swap(nums, depth, i);
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        res = new LinkedList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), 0);
        return res;
    }


    /**
     * 使用数组来表示对应位置的元素是否已经被使用
     */
    private void dfs(int[] nums, boolean[] used, List<Integer> output, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            output.add(nums[i]);
            dfs(nums, used, output, depth + 1);
            output.remove(output.size() - 1);
            used[i] = false;
        }
    }

}
