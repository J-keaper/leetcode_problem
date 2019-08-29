package cn.keaper.p258;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class Solution {

    public int addDigits(int num) {
        int res = num;
        while (res >= 10){
            int sum = 0,temp = res;
            while(temp != 0){
                sum += temp %10;
                temp /= 10;
            }
            res = sum;
        }
        return res;
    }

}
