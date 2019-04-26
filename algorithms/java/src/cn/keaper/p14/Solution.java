package cn.keaper.p14;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int pos = 0;
        for(int i = 0;;i++){
            for(int j = 0;j < strs.length ; j++){
                if(i >= strs[j].length()){
                    return strs[0].substring(0,pos);
                }
                if(j != 0 && strs[j].charAt(i) != strs[j - 1].charAt(i)){
                    return strs[0].substring(0,pos);
                }
            }
            pos ++;
        }
    }
}