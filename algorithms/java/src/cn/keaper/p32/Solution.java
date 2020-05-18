package cn.keaper.p32;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Solution {

    /**
     * 栈底永远保存着当前有效子串的前一个字符的下标,所以一开始要将-1放入栈中
     * 1. 遇到左括号，入栈
     * 2. 遇到右括号
     *    2.1 如果栈顶元素出栈后，栈内剩下的元素不为空，则说明弹出的这个栈顶元素一定是左括号，因为栈底有保险。
     *    2.2 如果栈顶元素出栈后，栈内为空，则说明刚刚弹出的这个栈顶元素就是之前的“有效子串前一位的字符下标”，所以此时应该使用当前的右括号的下标入栈，更新这个“有效子串前一位的字符下标”。
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * 在这种方法中，我们利用两个计数器 left 和 right
     * 首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，我们增加 left 计算器;
     * 对于遇到的每个 ‘)’ ，我们增加 right 计数器。
     * 每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
     * 如果 right 计数器比 left 计数器大时，我们将 left 和 right 计数器同时变回 0 。
     * 我们从右到左做一遍类似的工作
     * <p>
     * 详细解释：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/218953
     * <p>
     * 简单描述就是将整个字符串按照"多余的右括号"和"多余的左括号"之间的分界线，分为左右两部分。
     * 从左到右和从右到左分别统计两部分的有效括号串的长度
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }


    /**
     * 动态规划
     *
     * dp[i] 表示 以第i个位置为结束(包含第i个字符)的最长有效括号串长度
     * 状态转移:
     *  1. 如果s[i] == '(',那么 dp[i] 一定是0
     *  2. 如果s[i] == ')',那么有两种情况：
     *      2.1 如果s[i-1] == '(',dp[i] = dp[i-2] + 2
     *      2.2 如果s[i-1] == ')',那么如果之前有一个'('能与之匹配，便可以扩展长度,
     *          也就是如果s[i-dp[i-1]-1] == '(',那么可以与当前')'匹配,dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2
     *
     *  注意边界情况
     */
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i - 2 < 0 ? 0 : dp[i - 2]) + 2;
                } else if((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] -1) == '('){
                    dp[i] = ((i - dp[i - 1] - 2) < 0 ? 0 : dp[i - dp[i - 1] - 2]) + dp[i - 1] + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}