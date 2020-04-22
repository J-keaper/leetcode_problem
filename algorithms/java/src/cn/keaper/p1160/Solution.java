package cn.keaper.p1160;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class Solution {

    /**
     * 记录chars中的每个字符数量，只要word中的字符数量小于等于chars即可以拼出word
     *
     */
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[128];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i)] ++;
        }
        int res = 0;
        for (String word : words) {
            int[] map = Arrays.copyOf(count, 128);
            if(canSpell(word, map)){
                res += word.length();
            }
        }
        return res;
    }


    private boolean canSpell(String s, int[] map){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c] --;
            if(map[c] < 0){
                return false;
            }
        }
        return true;
    }

}
