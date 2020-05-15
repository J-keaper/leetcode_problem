package cn.keaper.p220;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Solution {

    /**
     * 遍历元素，维护一个长度为K的滑动窗口(满足下标差值不超过k)，对于每个元素X，求出当前窗口内
     * [小于等于X的最大值，大于等于X的最小值]，如果X与这两个数的差值小于等于t，说明有解
     *
     * [小于等于X的最大值，大于等于X的最小值] 用二叉搜索数结构可以很容易的得到，因为左孩子就是最大下限，右孩子就是最小上限
     * int计算可能会越界，使用long
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];
            Long floor = set.floor(x);
            Long ceiling = set.ceiling(x);
            if((floor != null && x - floor <= t) ||
                    (ceiling != null && ceiling - x <= t)){
                return true;
            }
            set.add(x);
            if(i >= k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}
