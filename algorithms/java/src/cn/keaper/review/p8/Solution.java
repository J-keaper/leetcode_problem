package cn.keaper.review.p8;

public class Solution {

    public int myAtoi(String str) {
        int i = 0;
        long res = 0;
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        boolean positive = true;
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            positive = str.charAt(i) == '+';
            i++;
        }
        while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')){
            res = res * 10 + str.charAt(i) - '0';
            i++;
            if(positive && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(!positive && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return positive ? (int)res : (int)-res;
    }
}
