package cn.keaper.p131;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(res, new ArrayList<>(), s);
        return res;
    }

    /**
     * 从字符串中取出一段回文串，并且对剩余的字符串递归地进行，如果最后字符串为空，那么就得到了一个解
     */
    private void partition(List<List<String>> ans, List<String> part, String s) {
        if(s.length() == 0 && !part.isEmpty()){
            ans.add(new ArrayList<>(part));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if(checkPalindrome(left)){
                part.add(left);
                partition(ans, part, s.substring(i));
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private Boolean[][] isPalindrome;

    /**
     * 对回文串的状态进行缓存 并且 不对字符串进行截取 进行优化
     */
    public List<List<String>> partition1(String s) {
        isPalindrome = new Boolean[s.length()][s.length()];
        List<List<String>> res = new ArrayList<>();
        partition1(res, new ArrayList<>(), s, 0, s.length() - 1);
        return res;
    }

    private void partition1(List<List<String>> ans, List<String> part, String s, int l, int r) {
        if(l > r && !part.isEmpty()){
            ans.add(new ArrayList<>(part));
            return;
        }
        for (int i = l; i <= r; i++) {
            if(checkPalindrome1(s, l, i)){
                part.add(s.substring(l, i + 1));
                partition1(ans, part, s, i + 1, r);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean checkPalindrome1(String s, int start, int end){
        if(isPalindrome[start][end] != null){
            return isPalindrome[start][end];
        }
        int l = start, r = end;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome[start][end] = false;
            }
            l++;
            r--;
        }
        return isPalindrome[start][end] = true;
    }

}
