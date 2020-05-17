package cn.keaper.p290;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/word-pattern/
 */
public class Solution {


    /**
     * Similar with Problem 205
     * @see cn.keaper.p205.Solution
     *
     * time complexity : O(N)
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> k2v = new HashMap<>();
        Map<String,Character> v2k = new HashMap<>();
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if(patternArray.length != strArray.length){
            return false;
        }
        for (int i = 0; i < patternArray.length; i++) {
            if(k2v.containsKey(patternArray[i]) || v2k.containsKey(strArray[i])){
                if(!strArray[i].equals(k2v.get(patternArray[i]))){
                    return false;
                }
            }else {
                k2v.put(patternArray[i],strArray[i]);
                v2k.put(strArray[i],patternArray[i]);
            }
        }
        return true;
    }


    /**
     * 更容易理解的方式
     * @see cn.keaper.p205.Solution#isIsomorphic4(String, String)
     */
    public boolean wordPattern2(String pattern, String str) {
        Map<Character,String> k2v = new HashMap<>();
        Map<String,Character> v2k = new HashMap<>();
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if(patternArray.length != strArray.length){
            return false;
        }
        for (int i = 0; i < patternArray.length; i++) {
            if(k2v.containsKey(patternArray[i]) && !k2v.get(patternArray[i]).equals(strArray[i])){
                return false;
            }
            if(v2k.containsKey(strArray[i]) && !v2k.get(strArray[i]).equals(patternArray[i])){
                return false;
            }
            k2v.put(patternArray[i],strArray[i]);
            v2k.put(strArray[i],patternArray[i]);
        }
        return true;
    }

}
