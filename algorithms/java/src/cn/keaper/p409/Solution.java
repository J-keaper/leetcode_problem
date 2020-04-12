package cn.keaper.p409;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class Solution {

    /**
     * 统计[a-z][A-Z]每个字符出现的次数
     * 如果一个字符出现偶数次，那一定可以在放到最后的回文串中
     * 除了左右对称的字符，回文串的中间位置可以再另外加一个字符
     * 所以如果有个字符出现了奇数次，那最后结果可以再加一
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0 ; i < s.length() ; i ++){
            count[s.charAt(i)]++;
        }
        int res = 0;
        for (int i : count) {
            res += (i >> 1) << 1;
            if((i & 1) == 1 && (res & 1) == 0){
                res ++;
            }
        }
        return res;
    }

}
