package cn.keaper.review.p32;

public class Solution {




    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public int longestValidParentheses1(String s) {
        int maxLen = 0;
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                left++;
            }else if(c == ')'){
                right++;
            }
            if(left == right){
                maxLen = Math.max(maxLen, left * 2);
            }
            if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                right++;
            }
            if(left == right){
                maxLen = Math.max(maxLen, left * 2);
            }
            if(left > right){
                left = right = 0;
            }
        }
        return maxLen;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses1("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses1(")()())"));
    }
}