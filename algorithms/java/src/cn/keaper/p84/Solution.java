package cn.keaper.p84;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Solution {

    /**
     * 考虑以一个柱子为最低高度所能构成的最大矩形，假设向左的第一个小于当前柱子高度的位置为l，向右第一个小于当前柱子的高度为r
     * 那么以该柱子为最低高度所能构成的最大矩形即为 横向[l+1,r-1],纵向[0,height]
     *
     * 那么问题转化成了如果求每个位置 左边第一个小于当前高度的位置、右边第一个大于当前高度的位置
     * 简单的想法是：从每个位置向两边扩展，时间复杂度：O(N^2)，会超时
     *
     * 考虑使用单调栈维护一个递增的序列，存放每个柱子的下标
     * 每当弹出元素时，[当前元素]就是[弹出元素]的右侧第一个小于它自身高度的位置
     * 弹出元素后，[栈顶元素]就是[弹出元素]的左侧第一个小于它滋生高度的位置
     *
     * 注意： 这里实际上描述为非递减栈更准确
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int pop = stack.pop();
                maxArea = Math.max(maxArea, heights[pop] * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
            }
            stack.push(i);
        }
        // 处理栈中剩余元素
        while (!stack.isEmpty()){
            int pop = stack.pop();
            maxArea = Math.max(maxArea, heights[pop] * (heights.length - 1 - (stack.isEmpty() ? -1 : stack.peek())));
        }
        return maxArea;
    }

    /**
     * 可以将原数组两边扩展一个0的虚拟柱子，避免处理边界条件
     */
    public int largestRectangleArea2(int[] heights) {
        int[] new_heights = new int[heights.length + 2];
        System.arraycopy(heights, 0, new_heights, 1, heights.length);
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[i] < new_heights[stack.peek()]){
                int pop = stack.pop();
                maxArea = Math.max(maxArea, new_heights[pop] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
