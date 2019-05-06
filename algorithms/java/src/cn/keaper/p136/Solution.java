package cn.keaper.p136;

public class Solution {

    /**
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }


}
