package cn.keaper.p44;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Solution {

    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, 0, removeDupStars(p), 0);
    }

    private String removeDupStars(String s){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i > 0 && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == '*'){
                continue;
            }
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans;
        if(j == p.length()){
            ans = i == s.length();
        } else if (i == s.length()) {
            ans = p.substring(j).equals("*");
        } else if (p.charAt(j) != '*') {  // 当前不为'*'，只要判断下一位置即可
            ans = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && isMatch(s, i + 1, p, j + 1);
        }else{
            ans = isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j);
        }
        dp[i][j] = ans;
        return ans;
    }

}
