package cn.keaper.review.p12;

public class Solution {

    private static final int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < radix.length; i++) {
            int count = num / radix[i];
            num %= radix[i];
            for (int j = 0; j < count; j++) {
                res.append(symbol[i]);
            }
        }
        return res.toString();
    }

}
