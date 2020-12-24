package cn.keaper.p455;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}
