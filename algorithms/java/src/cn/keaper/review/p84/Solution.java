package cn.keaper.review.p84;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights, 0, h, 1, heights.length);

        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]){
                int pop = stack.pop();
                maxArea = Math.max(maxArea, h[pop] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
