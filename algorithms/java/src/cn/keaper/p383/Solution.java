package cn.keaper.p383;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class Solution {


    /**
     * This solution is faster than follow two solution
     * when magazine's length is much larger than ransomNote's length
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] pos = new int[26];
        char[] arrayR = ransomNote.toCharArray();
        for (char c : arrayR) {
            int index = magazine.indexOf(c,pos[c - 'a']);
            if(index == -1){
                return false;
            }
            pos[c - 'a'] = index + 1;
        }
        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] count = new int[26];
        char[] arrayR = ransomNote.toCharArray();
        char[] arrayM = magazine.toCharArray();
        for (char c : arrayM) {
            count[c - 'a']++;
        }
        for (char c : arrayR) {
            count[c - 'a'] --;
            if(count[c- 'a'] < 0){
                return false;
            }
        }
        return true;
    }


    public boolean canConstruct1(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] countR = new int[26];
        int[] countM = new int[26];
        char[] arrayR = ransomNote.toCharArray();
        char[] arrayM = magazine.toCharArray();
        for (char c : arrayR) {
            countR[c - 'a']++;
        }
        for (char c : arrayM) {
            countM[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(countM[i] < countR[i]){
                return false;
            }
        }
        return true;
    }
}
