package cn.keaper.p205;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Solution {

    /**
     * cost: 1ms
     */
    public boolean isIsomorphic(String s, String t) {
        char[] k = new char[128];
        char[] v = new char[128];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char charS = S[i] , charT = T[i];
            if(k[charS] != '\0' || v[charT] != '\0'){
                if(k[charS] != charT){
                    return false;
                }
            }else {
                k[charS] = charT;
                v[charT] = charS;
            }
        }
        return true;
    }

    /**
     * 这种方式更容易理解
     * 维护两个方向的映射，只要发现任意一个方向的映射重复了，即不合法
     */
    public boolean isIsomorphic4(String s, String t) {
        char[] k = new char[128];
        char[] v = new char[128];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char charS = S[i] , charT = T[i];
            if(k[charS] != '\0' && k[charS] != charT){
                return false;
            }
            if(v[charT] != '\0' && v[charT] != charS){
                return false;
            }
            k[charS] = charT;
            v[charT] = charS;
        }
        return true;
    }


    /**
     * cost: 2ms
     * O(N)
     */
    public boolean isIsomorphic3(String s, String t) {
        char[] k = new char[128];
        char[] v = new char[128];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char charS = S[i] , charT = T[i];
            if(k[charS] != '\0' && k[charS] != charT){
                return false;
            }
            if(k[charS] == '\0' && v[charT] != '\0'){
                return false;
            }
            k[charS] = charT;
            v[charT] = charS;
        }
        return true;
    }


    /**
     * cost: 6ms
     * O(N^2)
     */
    public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * cost: 14ms
     * O(N^2)
     */
    public boolean isIsomorphic1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i) , charT = t.charAt(i);
            if(charMap.containsKey(charS) && !charMap.get(charS).equals(charT)){
                return false;
            }
            if(!charMap.containsKey(charS) && charMap.containsValue(charT)){
                return false;
            }
            charMap.put(charS,charT);
        }
        return true;
    }
}
