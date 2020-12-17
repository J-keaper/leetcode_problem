package cn.keaper.review.p13;

public class Solution {

    private static int map(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        if(s.length() == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int current = map(s.charAt(i));
            int next = map(s.charAt(i+1));
            res += current >= next ? current : -current;
        }
        res += map(s.charAt(s.length() - 1));
        return res;
    }



}
