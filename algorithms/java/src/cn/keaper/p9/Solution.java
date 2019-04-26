package cn.keaper.p9;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
class Solution {
    /**
     * approach 1
     * revert half of the number
     */
    public boolean isPalindrome(int x) {
        if(x < 0  || (x % 10 == 0 && x != 0)){
            return false;
        }
        int target = 0;
        while (x > target){
            target = target * 10 + x % 10;
            x = x / 10;
        }
        return target == x || target / 10 == x;
    }

    /**
     * approach 2
     * revert whole number
     */
    public boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        long source = x , target = 0;
        while (source != 0){
            target = target * 10 + source % 10;
            source = source / 10;
        }
        return target == x;
    }
}
