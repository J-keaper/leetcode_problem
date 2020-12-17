package cn.keaper.review.p5;

public class Solution {





    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = maxPalindrome(s, i, i);
            String res2 = maxPalindrome(s, i, i + 1);
            if(res1.length() > res.length()){
                res = res1;
            }
            if(res2.length() > res.length()){
                res = res2;
            }
        }
        return res;
    }

    private String maxPalindrome(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }


    /**
     * dp[i][j] = true , i == j
     * dp[i][j] = s[i] == s[j], i + 1 == j
     * dp[i][j] = dp[i+1][j-1] && s[i] == s[j], i + 1 < j
     */
    public String longestPalindrome1(String s) {
        String res = "";
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                boolean eq = s.charAt(i) == s.charAt(j);
                if(i == j){
                    dp[i][j] = true;
                }else if(i + 1 == j){
                    dp[i][j] = eq;
                }else {
                    dp[i][j] = dp[i+1][j-1] && eq;
                }
                if(dp[i][j] && (j - i + 1 > res.length())){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome1("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome1("cbbd"));
        System.out.println(new Solution().longestPalindrome("abbbb"));
        System.out.println(new Solution().longestPalindrome1("abbbb"));
        System.out.println(new Solution().longestPalindrome("abcde"));
        System.out.println(new Solution().longestPalindrome1("abcde"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome1("a"));
    }

}
