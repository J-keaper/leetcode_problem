package cn.keaper.p11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Solution {

    /**
     * 简化题目其实是找到两个位置i,j,满足 0<=i<j<=n，使得[i,j]之间能装的水最多
     * 水槽面积等于 (j-i+1) * min(height[i],height[j])
     *
     * 首先可以遍历所有i和j的组合，求每种组合最大值，复杂度O(N^2)
     *
     * 可以考虑使用双指针，注意矩形的面积由两个指针间的宽度和ij中间较短的一个高度决定
     * 从最左侧和最右侧向中间逼近知道两个指针相遇
     *
     * 指针的移动规则为，总是移动短板，原因是：
     * 1. 如果移动短板，宽度-1，高度可能增加，面积可能变大
     * 2. 如果移动长板，宽度-1，高度不变或者减少，面积不会变大
     * 所以我们的策略应该是移动短板
     *
     * 其实相当于暴力解法中消除了一些无效的状态
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r){
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxArea;
    }
}
