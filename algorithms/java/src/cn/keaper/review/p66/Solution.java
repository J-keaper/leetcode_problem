package cn.keaper.review.p66;

public class Solution {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9){
            i--;
        }
        for (int j = i + 1; j < digits.length; j++){
            digits[j] = 0;
        }
        if(i >= 0){
            digits[i]++;
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
