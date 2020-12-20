package cn.keaper.p1081;

/**
 * Smallest Subsequence of Distinct Characters
 */
public class Solution {

    /**
     * 与p316一样
     */
    public String smallestSubsequence(String s) {
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
