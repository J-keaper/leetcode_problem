package cn.keaper.p62;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class Solution {

    /**
     * 动态规划思想，从每个位置可选的方向只有向下和向右
     * 如果向下，问题则变为求解原问题对于 原网格减去第一行 的解
     * 如果向右，问题则变为求解原问题对于 原网格减去第一列 的解
     *
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
