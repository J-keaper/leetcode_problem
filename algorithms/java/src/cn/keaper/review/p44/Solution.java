package cn.keaper.review.p44;

public class Solution {

    /**
     * dp[i][j] 表示 s.substring(i) 是否匹配 p.substring(j)
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true; // 匹配空串

        for (int i = s.length(); i >= 0; i--) { // 从零开始是因为s为空也有可能与p匹配
            for (int j = p.length() - 1; j >= 0; j--) {
                if(p.charAt(j) != '*'){ // 如果不是*，当前字符匹配且后续匹配即可
                    boolean matchFirst = i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                    dp[i][j] = matchFirst && dp[i + 1][j + 1];
                }else { // 如果是*，需要区分*是否匹配当前字符
                    dp[i][j] = dp[i][j + 1] || (i < s.length() && dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa","a"));
        System.out.println(new Solution().isMatch("aa","*"));
        System.out.println(new Solution().isMatch("cb","?a"));
        System.out.println(new Solution().isMatch("adceb","*a*b"));
        System.out.println(new Solution().isMatch("acdcb","a*c?b"));


    }
}
