package cn.keaper.p387;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Solution {

    /**
     * The solution is faster when input is much large and unique character is much more
     */
    public int firstUniqChar(String s) {
        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)){
                res = Math.min(index,res);
            }
        }
        return res == s.length() ? -1 : res;
    }


    /**
     * statistics the count of every character, result is first character that count equals 1
     */
    public int firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            count[c - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if(count[array[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
