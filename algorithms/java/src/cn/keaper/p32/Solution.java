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
            if(c == '('){
                stack.push(i);
            }else if(c == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
