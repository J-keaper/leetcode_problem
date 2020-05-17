package cn.keaper.p680;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class Solution {


    /**
     * 如果只删除一个字符即可满足回文
     * 那么从字符串两端开始比较，当遇到不同的字符时可以选择跳过左边或者跳过右边
     * 分别判断是否回文即可
     */
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)){
            l++;
            r--;
        }
        if(l > r){ // 不用删除就可以满足条件
            return true;
        }

        int nl = l, nr = r - 1;
        while (nl <= nr && s.charAt(nl) == s.charAt(nr)){
            nl++;
            nr--;
        }
        if(nl > nr){ // 删除右边一个字符
            return true;
        }

        nl = l + 1; nr = r;
        while (nl <= nr && s.charAt(nl) == s.charAt(nr)){
            nl++;
            nr--;
        }
        if(nl > nr){ // 删除左边一个字符
            return true;
        }

        return false;
    }

}
