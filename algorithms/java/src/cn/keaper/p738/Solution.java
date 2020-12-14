package cn.keaper.p738;

public class Solution {


    /**
     * 小于等于N的最大的数应该是，前一段非递减加上后一段都为9的数字
     *
     * 按照高位到低位的顺序，首先找到非递减的最后一个位置，然后将当前位减一
     * 然后依次往前，级联更新前面的位使得前一段仍然保持非递减
     * 对于之后的数字，全部置位9可以使得最后数字最大
     */
    public int monotoneIncreasingDigits(int N) {
        int[] digit = new int[11];
        int count = N, k = 10;
        while (count > 0){
            digit[k--] = count % 10;
            count /= 10;
        }
        int i = 1, res = 0;
        while (i <= 10 && digit[i] >= digit[i-1]){
            res = res * 10 + digit[i];
            i++;
        }
        if(i > 10){
            return res;
        }
        int t = i;
        while (t > 0 && digit[t] < digit[t-1]){
            digit[t-1]--;
            t--;
        }
        res = 0;
        for (int j = 0; j <= 10; j++) {
            res = res * 10 + (j > t ? 9 : digit[j]);
        }
        return res;
    }
}
