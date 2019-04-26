package cn.keaper.p122;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    /**
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
