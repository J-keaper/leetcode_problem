package cn.keaper.p567;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
            if(i >= s1.length()){
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if(isEqual(count1, count2)){
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[] count1, int[] count2){
        for (int j = 0; j < 26; j++) {
            if(count1[j] != count2[j]) return false;
        }
        return true;
    }
}
