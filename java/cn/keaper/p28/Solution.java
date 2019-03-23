package cn.keaper.p28;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        // just need up to haystack.length() - needle.length()
        for (int i = 0 ; i <= haystack.length() - needle.length() ; i ++){
            if(haystack.substring(i , i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello","hello"));
        System.out.println(solution.strStr("aaaaa","bba"));
        System.out.println(solution.strStr("aaaaa","a"));
        System.out.println(solution.strStr("aaaaa","aaa"));
        System.out.println(solution.strStr("aaaaab","b"));
    }
}
