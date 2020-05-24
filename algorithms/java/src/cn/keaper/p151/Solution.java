package cn.keaper.p151;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class Solution {

    public String reverseWords(String s) {
        String[] wordList = split(s);
        reverseWords(wordList);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < wordList.length; i++) {
            if(i > 0) res.append(" ");
            res.append(wordList[i]);
        }
        return res.toString();
    }

    private String[] split(String s){
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        while (true){
            while (l < s.length() && s.charAt(l) == ' ') {
                l++;
                r++;
            }
            while (r < s.length() && s.charAt(r) != ' ') {
                r++;
            }
            if(l < r){
                res.add(s.substring(l,r));
                l = r;
            }else {
                break;
            }
        }
        return res.toArray(new String[0]);
    }


    private void reverseWords(String[] wordList){
        int l = 0, r = wordList.length - 1;
        while (l < r){
            String temp = wordList[r];
            wordList[r] = wordList[l];
            wordList[l] = temp;
            l++;
            r--;
        }
    }



}
