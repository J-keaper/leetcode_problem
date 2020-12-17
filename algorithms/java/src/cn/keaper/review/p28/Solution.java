package cn.keaper.review.p28;

public class Solution {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int a = i, b = 0;
            while (a < haystack.length() && b < needle.length()
                    && haystack.charAt(a) == needle.charAt(b)){
                a++;
                b++;
            }
            if(b == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("hello", "llo"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
    }
}
