package cn.keaper.p1370;

/**
 * https://leetcode.com/problems/increasing-decreasing-string/
 */
public class Solution {

    public String sortString(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()){
            count[c - 'a']++;
        }

        int len = s.length();
        char[] res = new char[len]; // 使用char数组比StringBuilder效率更高
        int index = 0;
        while (index < len){
            for (int i = 0; i <= 25 && index < len; i++) {
                if(count[i] > 0) {
                    count[i]--;
                    res[index++] = (char)('a' + i);
                }
            }
            for (int i = 25; i >= 0 && index < len; i--) {
                if(count[i] > 0) {
                    count[i]--;
                    res[index++] = (char)('a' + i);
                }
            }
        }
        return new String(res);
    }

}
