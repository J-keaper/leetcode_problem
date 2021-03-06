package cn.keaper.p58;


/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int result = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' '){
            i --;
        }
        while (i >= 0 && s.charAt(i) != ' '){
            result ++;
            i --;
        }
        return result;
    }
}
