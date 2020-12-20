package cn.keaper.p316;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Solution {

    /**
     * 与p402类似
     * 维护一个单调栈，依次将字符加入栈中
     * 如果当前数字小于栈顶元素，那么删除栈顶元素可以得到更小的数，应该删除，否则的话加入栈中
     *
     * 但是有两个限制条件：
     * 1. 每个字符必须都包含，所以如果栈顶元素在之后不会再出现了，那么就不能删除。为此我们需要记录每个元素的数量
     * 2. 每个字符只能出现一次，所以对于之前已经存在于栈中的字符，应该丢弃
     *
     * 与p1081一样
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        boolean[] vis = new boolean[26];
        char[] stack = new char[s.length()];
        int top = 0;
        for (char c : s.toCharArray()) {
            if(!vis[c - 'a']){
                while (top > 0 && stack[top - 1] > c && count[stack[top - 1] - 'a'] > 0){
                    vis[stack[top - 1] - 'a'] = false;
                    top--;
                }
                stack[top++] = c;
                vis[c - 'a'] = true;
            }
            count[c - 'a']--;
        }
        return new String(stack, 0, top);
    }
}
