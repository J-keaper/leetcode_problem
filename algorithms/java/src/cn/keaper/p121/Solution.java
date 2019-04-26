package cn.keaper.p121;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {

    /**
     * O(N)
     * 遍历一次，计算每天的价格与当天之前的最小价格的差值，即为当天卖出所能得到的最大利润，遍历每一天即可
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfit = 0;
        for(int i = 0 ; i < prices.length ; i ++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                maxProfit = Integer.max(maxProfit,prices[i] - minPrice);
            }
        }
        return maxProfit;
    }


    /**
     * 转化为最大连续子数组和问题，即可用O(N)解决
     * 求出每天与前一天的价格差值，求最大连续子数组和即可
     * 最大子数组问题 [https://leetcode.com/problems/maximum-subarray/]
     */
    public int maxProfit2(int[] prices) {
        int max = 0,sum = 0;
        for(int i = 0 ; i < prices.length - 1 ; i ++){
            prices[i] = prices[i + 1] - prices[i];
            sum += prices[i];
            if(max < sum){
                max = sum;
            }
            if(sum <= 0){
                sum = 0;
            }
        }
        return max;
    }

    /**
     * O(N^2)
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        for(int i = 0 ; i < prices.length - 1; i ++){
            for(int j = i + 1; j < prices.length ; j ++){
                res = Integer.max(res,prices[j] - prices[i]);
            }
        }
        return res;
    }
}
