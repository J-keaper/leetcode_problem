package cn.keaper.p1422;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class Solution {

    /**
     * 用一个数组保存从左到右0的累计数量，然后从数组另一端遍历，同时累加1的个数，计算最大值
     */
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int[] count0 = new int[s.length()];
        count0[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            count0[i] = count0[i - 1] + (chars[i] == '0' ? 1 : 0);
        }
        int res = 0, count1 = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i] == '1'){
                count1 ++;
            }
            res = Math.max(res, count1 + count0[i - 1]);
        }
        return res;
    }
}
