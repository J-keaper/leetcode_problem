package cn.keaper.p125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class Solution {

    /**
     * cost:1ms
     */
    public boolean isPalindrome(String s) {
        int[] map = new int[256];
        for (int i = 0; i < 10; i++)
            map[i + '0'] = 1 + i;
        for (int i = 0; i < 26; i++) {
            map[i + 'a'] = 11 + i;
            map[i + 'A'] = 11 + i;
        }
        char[] chars = s.toCharArray();
        int l = 0,r = chars.length - 1;
        while (l < r){
            int lm = map[chars[l]];
            int rm = map[chars[r]];
            if(lm != 0 && rm != 0){
                if(lm != rm){
                    return false;
                }
                l ++;
                r --;
            }else {
                if(lm == 0){
                    l ++;
                }
                if(rm == 0){
                    r --;
                }
            }
        }
        return true;
    }

    /**
     * cost:2ms
     */
    public boolean isPalindrome4(String s) {
        int[] map = new int[256];
        for (int i = 0; i < 10; i++)
            map[i + '0'] = 1 + i;
        for (int i = 0; i < 26; i++) {
            map[i + 'a'] = 11 + i;
            map[i + 'A'] = 11 + i;
        }
        for (int l = 0,r = s.length() - 1; l <= r ; l++,r--){
            while (l < s.length() && map[s.charAt(l)] == 0) l++;
            while (r >= 0 && map[s.charAt(r)] == 0) r--;
            if(l < s.length() && r >= 0 && map[s.charAt(l)] != map[s.charAt(r)]){
                return false;
            }
        }
        return true;
    }


    /**
     * cost:4ms
     */
    public boolean isPalindrome3(String s) {
        StringBuilder clean = new StringBuilder();
        for (char c : s.toCharArray()){
            if(isLetterOrDigit(c)){
                clean.append(c);
            }
        }
        s = clean.toString();
        for (int l = 0,r = s.length() - 1; l <= r ; l++,r--){
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
        }
        return true;
    }

    /**
     * cost:3ms
     */
    public boolean isPalindrome2(String s) {
        for (int l = 0,r = s.length() - 1; l < r ; l++,r--){
            while (l < s.length() && !isLetterOrDigit(s.charAt(l))) l++;
            while (r >= 0 && !isLetterOrDigit(s.charAt(r))) r--;
            if(l < s.length() && r >= 0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
        }
        return true;
    }

    private boolean isLetterOrDigit(char c){
        return (c >= '0' && c <= '9') || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }


    /**
     * cost:4ms
     */
    public boolean isPalindrome1(String s) {
        for (int l = 0,r = s.length() - 1; l <= r ; l++,r--){
            while (l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(l < s.length() && r >= 0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
        }
        return true;
    }


}
