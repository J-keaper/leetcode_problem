package cn.keaper.p322;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class Solution {

    /**
     * 动态规划
     * dp[S] 表示凑够 S 最少需要的硬币个数
     * dp[i] = min(dp[i - coins[j]])+1
     *
     * 注意处理无解的情况
     */
    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i - coin >= 0){
                    dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] >= MAX ? -1 : dp[amount];
    }

}
