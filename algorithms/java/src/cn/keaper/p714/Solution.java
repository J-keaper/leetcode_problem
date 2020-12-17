package cn.keaper.p714;

public class Solution {

    /**
     * 动态规划
     * dp[i][0]表示当天不持有股票的利润
     * dp[i][1]表示当前持有股票的利润
     * <p>
     * 第i天不持有股票，要么是继续不持有，要么是前一天持有当天卖出，利润加上当天价格
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * <p>
     * 第i天持有股票，要么是继续是有，要么是前一天不持有，当天买入，利润减去当天价格和手续费
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
     * <p>
     * 假设N天，最后结果就是dp[N-1][0] （光买不卖肯定没有利润）
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 状态压缩
     */
    public int maxProfit1(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            int new0 = Math.max(dp[0], dp[1] + prices[i]);
            int new1 = Math.max(dp[1], dp[0] - prices[i] - fee);
            dp[0] = new0;
            dp[1] = new1;
        }
        return dp[0];
    }


    /**
     * 贪心
     * 我们用minPrice表示当前的最小买入价格+手续费，并在遍历过程中始终维护这个值
     * 如果遇到价格大于minPrice，选择将其卖出我们可以盈利
     * 但是因为可能是连续的一笔交易，所以此时minPrice只更新为当天价格即可
     * 如果后续继续涨价则相当于不需要一笔新的手续费重新购入
     */
    public int maxProfit2(int[] prices, int fee) {
        int minPrice = prices[0] + fee;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if(prices[i] + fee < minPrice){
                minPrice = prices[i] + fee;
            }
            if(prices[i] > minPrice){
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }


    /**
     * 与上一种解法类似，只不过这次我们将手续费的计算放在了卖出的时候
     * minPrice表示的当天之前的股票最低价
     * 如果当天股价大于minPrice加手续费，可以选择卖出
     * 卖出的当天的minPrice应该等于 当天股价减去手续费用 ，减去的手续费是用来补偿前一天提早卖出损失的手续费
     */
    public int maxProfit3(int[] prices, int fee) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i] > minPrice + fee){
                maxProfit += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }
        return maxProfit;
    }

}