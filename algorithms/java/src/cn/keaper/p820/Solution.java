package cn.keaper.p820;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class Solution {


    /**
     * 维护一个集合，用字符串数组初始化，
     * 遍历每个字符串，将其所有前缀从集合中移除
     * 最后求集合中所有字符串的长度之和即为所求
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++ ){
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }


    /**
     * 将每个字符串逆序后排序
     * 遍历相同前缀的字符串的最长长度相加
     */
    public int minimumLengthEncoding1(String[] words) {
        if(words.length == 0){
            return 0;
        }
        if(words.length == 1){
            return words[0].length() + 1;
        }
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        Arrays.sort(words, String::compareTo);
        int res = 0;
        for (int i = 1; i < words.length; i++) {
            if(!words[i].contains(words[i - 1])){
                res += words[i-1].length() + 1;
            }
        }
        return res + words[words.length - 1].length() + 1;
    }



}
