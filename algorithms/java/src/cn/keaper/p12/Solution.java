package cn.keaper.p12;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Solution {

    /**
     * 将不同大小的数字单位从大到小排列，然后从大到小依次取数
     */
    public String intToRoman(int num) {
        final int[] radix = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        final String[] symbol = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num = num % radix[i];
            for (int j = 0; j < count; j++) {
                str.append(symbol[i]);
            }
        }
        return str.toString();
    }

}
