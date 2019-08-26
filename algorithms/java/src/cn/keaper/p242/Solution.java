package cn.keaper.p242;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Solution {

    /**
     * Two hash table
     * Time: O(N)
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] countS = new int[26], countT = new int[26];
        for (char c : s.toCharArray()) {
            countS[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            countT[c - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if(countS[i] != countT[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * One hash table
     * Time: O(N)
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0){
                return false;
            }
        }
        return true;
    }


    /**
     * Sort String
     * Time: O(N*logN)
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray() , chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);
    }



}
