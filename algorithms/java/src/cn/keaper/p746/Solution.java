package cn.keaper.p746;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class Solution {

    /**
     * dp[i]表示到达第i级台阶所需的最小花费
     * dp[i] = cost[i], i < 2 小于２的位置可以直达，花费就是当前cost
     * dp[i] = cost[i] + min(dp[i-1],dp[i-2]), i >= 2，大于2的位置不能直达，花费最小值是最后一步跨异一步还是跨两步所需花费的最小值
     *
     * 最后结果是达到最后一级台阶或者倒数第二级台阶所需花费的最小值，因为最后一步不需要花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            dp[i] = cost[i];
            if(i - 2 >= 0){
                dp[i] += Math.min(dp[i-2], dp[i-1]);
            }
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 直接在原数组上修改
     */
    public int minCostClimbingStairs1(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }



}
