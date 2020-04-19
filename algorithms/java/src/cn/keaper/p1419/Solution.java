package cn.keaper.p1419;

/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 */
public class Solution {

    /**
     * 维护croak的个数，如果遇到当前字母，则肯定是由前面字母过来，前面字母数-1。
     * k代表结尾，一次喊叫的结束，所以遇到c的时候，先去消耗k，没有k了，需要新青蛙，答案+1
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        int res = 0;
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            if(ch == 'c'){
                if(k > 0){
                    k --;
                }else {
                    res ++;
                }
                c ++;
            }else if(ch == 'r'){
                r ++; c --;
            }else if(ch == 'o'){
                o ++; r --;
            }else if(ch == 'a'){
                a ++; o --;
            }else if(ch == 'k'){
                k ++; a --;
            }
            if(c < 0 || r < 0 || o < 0 || a < 0){
                return -1;
            }
        }
        if(c != 0 || r != 0 || o != 0 || a != 0){
            return -1;
        }
        return res;
    }


}
