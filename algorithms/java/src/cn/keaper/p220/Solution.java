package cn.keaper.p220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Solution {


    /**
     * Time: O(N)
     * Space: O(min(n,k))
     *
     * 与第一种方法一样的是维护一个长度为K的窗口
     * 区别在于窗口内如何判断计算与一个元素差值小于等于t的值存不存在
     * 第一种方法使用BST来维护窗口内离当前值最近的两个值[小于等于X的最大值，大于等于X的最小值]可以快速计算出结果
     *
     * 这里我们的思想是：
     * 将整个整数划分为若干个宽度为 [t+1] 的桶，每个数都归属于一个桶
     * 如果两个数的差值小于等于t，那么两个数所在的桶一定是同一个或者相邻
     *
     * 因此我们还是维护一个长度为K的窗口，同时用MAP维护窗口内数字所在桶到下标的映射
     * 如果有同一个桶中已经存在元素或者相邻桶中存在元素且满足差值条件，则最后有解，否则无解
     *
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) {
            return false;
        }
        Map<Long, Long> bucket = new HashMap<>(); // 保存每个桶中数字的下标，桶中最多只有一个数字，超过一个就可以直接返回了
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long p = getBucketIndex(nums[i], w); // 计算在第几个桶
            if(bucket.containsKey(p)){
                return true;
            }
            if(bucket.containsKey(p - 1) && Math.abs(nums[i] - bucket.get(p - 1)) < w){
                return true;
            }
            if(bucket.containsKey(p + 1) && Math.abs(nums[i] - bucket.get(p + 1)) < w){
                return true;
            }
            bucket.put(p, (long)nums[i]);
            if(i >= k){
                bucket.remove(getBucketIndex(nums[i-k],w)); // 移除超出窗口范围的数
            }
        }
        return false;
    }

    /**
     * 将整个整数划分为若干个宽度为W的桶
     * 计算X应该落在哪个桶中
     * 需要保证每个桶的大小一致
     * ...,[-3w,-2w-1],[,-2w,-w-1],[-w,-1],[0,w-1],[w,2w-1],[2w,3w-1],...
     *
     */
    private long getBucketIndex(long x, long w){
        return x >= 0 ? x / w : ((x + 1) / w - 1);
    }


    /**
     * Time: O(n*log(min(n,k)))
     * Space: O(min(n,k))
     * 遍历元素，维护一个长度为K的滑动窗口(满足下标差值不超过k)，对于每个元素X，求出当前窗口内
     * [小于等于X的最大值，大于等于X的最小值]，如果X与这两个数的差值小于等于t，说明有解
     *
     * [小于等于X的最大值，大于等于X的最小值] 用二叉搜索数结构可以很容易的得到，因为左孩子就是最大下限，右孩子就是最小上限
     * int计算可能会越界，使用long
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
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
