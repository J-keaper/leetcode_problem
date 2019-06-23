package cn.keaper.p171;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 镜像问题：P168
 */
public class Solution {


    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res = (res << 4) + (res << 3) + (res << 1) + (c - 'A' + 1);
        }
        return res;
    }
}
