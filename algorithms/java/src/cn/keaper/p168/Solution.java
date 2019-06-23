package cn.keaper.p168;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 镜像问题：P171
 */
class Solution {


    public String convertToTitle(int n){
        StringBuilder res = new StringBuilder();
        while (n > 0){
            n = n - 1;
            res.append((char)((n % 26) + 'A'));
            n = n / 26;
        }
        return res.reverse().toString();
    }
}