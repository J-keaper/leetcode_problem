package cn.keaper.p3;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    /**
     * 使用 l,r 维护一个窗口，窗口中的字符串是以s[r]为结束的最长无重复字符串
     * 每次将r向右移动一位，如果当前字符在之前已经出现过，并且处于窗口之内，那么调整窗口的左边界，使得字符串满足条件
     */
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        int maxLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            l = Math.max(l, pos[c] + 1);   // 调整字符串左边界，使得字符串满足不重复条件
            pos[c] = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
