package cn.keaper.p300;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Solution {


    /**
     * 贪心 + 二分
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     */
    public int lengthOfLIS(int[] nums) {
        int [] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int point = Arrays.binarySearch(tail, 0, res, num);
            if (point < 0) point = -1 - point;
            tail[point] = num;
            if (point == res) {
                res++;
            }
        }
        return res;
    }


    /**
     * 动态规划
     * time : O(N^2)
     * space : O(N)
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
     * dp[i] = max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * LIS = max(dp[i]),其中0≤i<n
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int dp[] = new int[nums.length];
        int res = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            int max = 0;
            for(int j = 0 ; j < i ; j ++){
                if(nums[j] < nums[i]){
                    max = Integer.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Integer.max(res, dp[i]);
        }
        return res;
    }








}
