package cn.keaper.p7;


/**
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
        long source = x , target = 0;
        while (source != 0){
            target = target * 10 + source % 10;
            source = source / 10;
        }
        if(target > Integer.MAX_VALUE || target < Integer.MIN_VALUE){
            return 0;
        }
        return (int) target;
    }
}