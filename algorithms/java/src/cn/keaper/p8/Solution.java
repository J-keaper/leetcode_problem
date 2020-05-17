package cn.keaper.p8;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Solution {

    /**
     * 注意点：
     * 1. 正负号
     * 2. 超过范围
     */
    public int myAtoi(String str) {
        int i = 0;
        long result = 0;
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        boolean negative = false;
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            negative = str.charAt(i) == '-';
            i++;
        }
        while (i < str.length() && '0' <= str.charAt(i) && str.charAt(i) <= '9'){
            result = result * 10 + (str.charAt(i) - '0');
            i++;
            if(!negative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(negative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (negative ? -result : result);
    }
}
