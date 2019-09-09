package cn.keaper.p345;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class Solution {

    public String reverseVowels(String s) {
        boolean[] isVowel = new boolean[256];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
        isVowel['A'] = true;
        isVowel['E'] = true;
        isVowel['I'] = true;
        isVowel['O'] = true;
        isVowel['U'] = true;
        int len = s.length();
        char[] sArray = s.toCharArray();
        int l = 0,r = len - 1;
        while (l < r){
            if(isVowel[sArray[l]] && isVowel[sArray[r]]){
                char temp = sArray[l];
                sArray[l] = sArray[r];
                sArray[r] = temp;
                l++;
                r--;
                continue;
            }
            if(!isVowel[sArray[l]]){
                l++;
            }
            if(!isVowel[sArray[r]]){
                r--;
            }
        }
        return new String(sArray);
    }

}
