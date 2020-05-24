package cn.keaper.p43;


/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class Solution {

    /**
     * 模拟乘法列竖式
     * 将每一个位与另一位相乘得到一个数，并一次累加
     */
    public String multiply(String num1, String num2) {
        String res = "0";
        for (int i = 0; i < num1.length(); i++) {
            int digit = num1.charAt(num1.length() - i - 1) - '0';
            String oneMultiply = multiply(num2, digit, i);
            res = add(res, oneMultiply);
        }
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        return i < res.length() ? res.substring(i) : "0";
    }

    /**
     * 一个数乘以另一个数的一位
     * @param times 表示左移几位
     */
    private String multiply(String num, int multiplier, int times){
        StringBuilder res = new StringBuilder();
        while (times-- > 0){
            res.append('0');
        }
        int carry = 0;
        for(int i = num.length() - 1; i >= 0; i--){
            int product = (num.charAt(i) - '0') * multiplier + carry;
            res.append((char)('0' + product % 10));
            carry = product / 10;
        }
        if(carry != 0){
            res.append((char)('0' + carry));
        }
        return res.reverse().toString();
    }

    /**
     * 两数相加
     */
    private String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0;) {
            int digit1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int digit2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
            int sum = digit1 + digit2 + carry;
            res.append((char)('0' + (sum % 10)));
            carry = sum / 10;
            if (i >= 0) i--;
            if (j >= 0) j--;
        }
        if(carry != 0){
            res.append((char)('0' + carry));
        }
        return res.reverse().toString();
    }


}
