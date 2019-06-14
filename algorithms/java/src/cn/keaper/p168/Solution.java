package cn.keaper.p168;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
class Solution {

    /**
     * 一位的数有 26 个 ，两位的有 26^2 个，n位的数有 26^n 个
     * 所以先算出有几位，然后就可以按照26进制转换成字母，注意位数是固定的
     */
    public String convertToTitle(int n) {
        long fac = 26,i = 1;
        while (n > fac){
            n -= fac;
            fac *= 26;
            i ++;
        }
        StringBuilder res = new StringBuilder();
        n --;
        while (i -- > 0){
            res.append((char)((n % 26) + 'A'));
            n = n / 26;
        }
        return res.reverse().toString();
    }
}