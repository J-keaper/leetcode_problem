package cn.keaper.review.p58;

public class Solution {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        int len = 0;
        while (i >= 0 && s.charAt(i) != ' '){
            i--;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello world"));
        System.out.println(new Solution().lengthOfLastWord("hello world   "));
        System.out.println(new Solution().lengthOfLastWord("hello   world"));
        System.out.println(new Solution().lengthOfLastWord("  world"));
        System.out.println(new Solution().lengthOfLastWord("  world "));
    }
}
