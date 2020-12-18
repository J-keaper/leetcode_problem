package cn.keaper.review.p205;

public class Solution {


    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] s2t = new char[128], t2s = new char[128];
        for (int i = 0; i < s.length(); i++) {
            if(s2t[s.charAt(i)] != 0 && s2t[s.charAt(i)] != t.charAt(i)){
                return false;
            }
            if(t2s[t.charAt(i)] != 0 && t2s[t.charAt(i)] != s.charAt(i)){
                return false;
            }
            s2t[s.charAt(i)] = t.charAt(i);
            t2s[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
        System.out.println(new Solution().isIsomorphic("foo", "bar"));
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}
