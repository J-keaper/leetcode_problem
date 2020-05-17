package cn.keaper.p10;


/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Solution {


    //****************方法1****************

    /**
     * 递归
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {    // 如果模式串为空，则只要匹配串为空即可
            return s.isEmpty();
        }
        // 这里需要注意模式串不为空，但是匹配串为空，也是又可能匹配成功的
        boolean matchFirst = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') { // 存在 '*'
            return (matchFirst && isMatch(s.substring(1), p)) // 当前位匹配，看是否能继续匹配多次
                    || isMatch(s, p.substring(2));  // 当前位不匹配(这里包了模式串为空的情况)，跳过 '*' 继续匹配
        }
        return matchFirst && isMatch(s.substring(1), p.substring(1));   // 不存在 '*' , 直接递归判断下一位
    }

    private Boolean[][] dp;

    //****************方法2****************

    /**
     * 动态规划，自顶向下
     * 使用dp[][]保存中间结果
     */
    public boolean isMatch2(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch2(s, 0, p, 0);
    }

    public boolean isMatch2(String s, int i, String p, int j){
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean ans;
        if(j == p.length()) {
            ans = i == s.length();
        }else{
            boolean matchFirst = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                ans = (matchFirst && isMatch2(s, i + 1, p, j))
                    || isMatch2(s, i, p, j + 2);
            }else{
                ans = matchFirst && isMatch2(s, i + 1, p, j + 1);
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    //****************方法3****************

    /**
     * 动态规划，自底向上
     */
    public boolean isMatch3(String s, String p){
        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean matchFirst = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                    dp[i][j] = (matchFirst && dp[i + 1][j]) || dp[i][j + 2];
                }else{
                    dp[i][j] = matchFirst && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}