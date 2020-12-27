package cn.keaper.p188;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Solution {

    /**
     * 我们把买入+卖出算作一笔完整交易
     * buy[i][j] 表示 第i天手上持有股票并且已经进行过j笔交易，注意当前交易不算
     * sell[i][j] 表示 第i天手上不持有股票并且已经进行过j笔交易
     *
     * buy[i][j] = max(buy[i-1][j], sell[i-1][j] - prices[i])
     * sell[i][j] = max(sell[i-1][j], buy[i-1][j-1] + prices[i])
     */
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);

        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = - 2000;
        }
        for (int i = 1; i < n; i++){
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j-1] + prices[i]);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i <= k; i++) {
            maxProfit = Math.max(maxProfit, sell[n-1][i]);
        }
        return maxProfit;
    }

    /**
     * 因为buy数组和sell数组只与前一天的值有关，所以可以使用一维数组优化
     */
    public int maxProfit1(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = - 2000;
        }
        for (int i = 1; i < n; i++){
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                int newBuy = Math.max(buy[j], sell[j] - prices[i]);
                int newSell = Math.max(sell[j], buy[j-1] + prices[i]);
                buy[j] = newBuy;
                sell[j] = newSell;
            }
        }
        int maxProfit = 0;
        for (int i = 0; i <= k; i++) {
            maxProfit = Math.max(maxProfit, sell[i]);
        }
        return maxProfit;
    }
}
