package cn.keaper.p122;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    /**
     * 贪心，只要可以盈利就可以卖出获得利润
     * add all positive diff between two days
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1 ;  i < prices.length ; i ++){
            res += Integer.max(prices[i] - prices[i - 1],0);
        }
        return res;
    }

    /**
     * 动态规划
     * dp[i][0]表示当天不持有股票的利润
     * dp[i][1]表示当前持有股票的利润
     *
     * 第i天不持有股票，要么是继续不持有，要么是前一天持有当天卖出，利润加上当天价格
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *
     * 第i天持有股票，要么是继续是有，要么是前一天不持有，当天买入，利润减去当天价格
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     *
     * 假设N天，最后结果就是dp[N-1][0] （光买不卖肯定没有利润）
     */
    public int maxProfit2(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 动态规划，状态压缩
     * 因为只与前一天有关，所以可以只用两个变量完成
     */
    public int maxProfit3(int[] prices){
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int new0 = Math.max(dp[0], dp[1] + prices[i]);
            int new1 = Math.max(dp[1], dp[0] - prices[i]);
            dp[0] = new0;
            dp[1] = new1;
        }
        return dp[0];
    }


    /**
     * find all peak and valley,add diff between peak and valley
     */
    public int maxProfit1(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int res = 0;
        int high,low;
        for(int i = 0 ;  i < prices.length - 1; i ++){
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) i ++;
            low = prices[i];
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) i ++;
            high = prices[i];
            res += (high - low);
        }
        return res;
    }

}
