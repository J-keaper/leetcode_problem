package cn.keaper.review.p14;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if(j == strs[i].length() || strs[i].charAt(j) != strs[i-1].charAt(j)){
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

}
