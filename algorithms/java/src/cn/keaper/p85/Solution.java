package cn.keaper.p85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Solution {


    /**
     * 这题其实是p84的变种，p84是求柱状图中的最大面积
     * 而此题如果我们将每个位置上纵向连续的1个个数求出，也就是相当于高度
     * 也就是对于 matrix[i][j]，我们求出 matrix[i][j], matrix[i][j-1], ...., matrix[i][0] 中从 matrix[i][j] 开始连续的 1 的个数
     * 相当于我们在每一行求出了一个柱状图
     * <p>
     * 然后对于每一行上，我们可以使用暴力法求出以当前位置作为矩形最右下角的最大面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[][] height = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '1') {
                    height[j][i] = (j > 0 ? height[j - 1][i] : 0) + 1;
                } else {
                    height[j][i] = 0;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    minHeight = Math.min(minHeight, height[i][k]);
                    maxArea = Math.max((j - k + 1) * minHeight, maxArea);
                }
            }
        }
        return maxArea;
    }


    /**
     * 同样对于p84，我们使用单调栈做到了O(N)的时间复杂度
     * <p>
     * 对于此题，经过转化柱状图的过程，我们也可以使用单调栈对于每一行使用单调栈来求出每一行的最大面积
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[][] height = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '1') {
                    height[j][i] = (j > 0 ? height[j - 1][i] : 0) + 1;
                } else {
                    height[j][i] = 0;
                }
            }
        }
        int[] newHeight = new int[m + 2];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            System.arraycopy(height[i], 0, newHeight, 1, height[i].length);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < newHeight.length; j++) {
                while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[j]) {
                    int pop = stack.pop();
                    maxArea = Math.max(maxArea, newHeight[pop] * (j - 1 - stack.peek()));
                }
                stack.push(j);
            }
        }
        return maxArea;
    }
}
