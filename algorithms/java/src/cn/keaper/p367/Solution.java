package cn.keaper.p367;

public class Solution {

    public boolean isPerfectSquare(int num) {
        long l = 0,r = 1 << 16;
        while (l + 1< r){
            long m = (l + r) / 2;
            long mSqr = m * m;
            if(mSqr <= num){
                l = m;
            }else {
                r = m;
            }
        }
        return l * l == num || r * r == num;
    }
}
