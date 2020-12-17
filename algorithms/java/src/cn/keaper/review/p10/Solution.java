package cn.keaper.review.p10;

public class Solution {

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if(j == p.length()){
            return i == s.length();
        }
        boolean matchFirst = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            return (matchFirst && isMatch(s, i + 1, p, j)) ||
                    isMatch(s, i, p, j + 2);
        }
        return matchFirst && isMatch(s, i + 1, p, j + 1);
    }


    /**
     * dp[i][j] 表示 s.substring(i) 是否匹配 p.substring(j)
     */
    public boolean isMatch1(String s, String p){
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true; // 匹配空串
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean matchFirst = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    dp[i][j] = (matchFirst && dp[i+1][j]) || dp[i][j+2];
                }else{
                    dp[i][j] = matchFirst && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }



    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch1("aa", "a"));

        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch1("aa", "a*"));

        System.out.println(new Solution().isMatch("ab", ".*"));
        System.out.println(new Solution().isMatch1("ab", ".*"));

        System.out.println(new Solution().isMatch("aab", "c*a*b"));
        System.out.println(new Solution().isMatch1("aab", "c*a*b"));

        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new Solution().isMatch1("mississippi", "mis*is*p*."));
    }
}
