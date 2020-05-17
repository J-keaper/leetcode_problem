package cn.keaper.p5;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Solution {

    /**
     * 因为字符串是互为镜像的，所以我们可以枚举每个位置，向左右两边扩展
     * 注意这里位置并不是n个，因为可能回文串的长度为偶数个
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLen(s, i, i);        // 奇数长度
            int len2 = getLen(s, i, i + 1); // 偶数长度
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;  // 这个表达式可以统一奇数长度和偶数长度的计算方法
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLen(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }


    /**
     * 动态规划
     * dp[i][j] 表示 [i,j] 的子串是否是回文
     * 状态转移方程为
     * 1. dp[i][j] == true, if i == j
     * 2. dp[i][j] == s[i]==s[j], if i+1 == j
     * 3. dp[i][j] == dp[i+1][j-1] && s[i] == s[j] , i+1 < j
     */
    public String longestPalindrome1(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        int maxLen = 1, start = 0;
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            f[j][j] = true;
            for (int i = 0; i < j; i++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && (
                        j - i < 2 || f[i + 1] [j - 1]);
                if(f[i][j] && maxLen < (j - i + 1)){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
