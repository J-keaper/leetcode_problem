package cn.keaper.p389;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class Solution {


    /**
     * use XOR operation, a XOR a = 0 , a XOR 0 = 0 XOR a = a
     * XOR all character in two string , result is the letter that was added
     */
    public char findTheDifference(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        char res = arrayT[arrayT.length - 1];
        for (int i = 0; i < arrayS.length; i++) {
            res ^= arrayS[i];
            res ^= arrayT[i];
        }
        return res;
    }


    /**
     * calculate the count of every character , find the character that the count of two string is different
     */
    public char findTheDifference1(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        for (char c : arrayS) {
             countS[c - 'a'] ++;
        }
        for (char c : arrayT) {
            countT[c - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if(countS[i] != countT[i]){
                return (char)(i + 'a');
            }
        }
        throw new IllegalArgumentException("no result");
    }
}
