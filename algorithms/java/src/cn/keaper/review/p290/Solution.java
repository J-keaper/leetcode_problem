package cn.keaper.review.p290;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        Map<String, Character> s2c = new HashMap<>();
        Map<Character, String> c2s = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = s2c.get(words[i]);
            String s = c2s.get(pattern.charAt(i));
            if(c != null && !c.equals(pattern.charAt(i))){
                return false;
            }
            if(s != null && !s.equals(words[i])){
                return false;
            }
            s2c.put(words[i], pattern.charAt(i));
            c2s.put(pattern.charAt(i), words[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}
