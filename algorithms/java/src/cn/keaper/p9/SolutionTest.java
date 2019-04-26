package cn.keaper.p9;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void isPalindrome() {
        System.out.println(new Solution().isPalindrome(-100));
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(2442));
        System.out.println(new Solution().isPalindrome(111));
        System.out.println(new Solution().isPalindrome(2222));
        System.out.println(new Solution().isPalindrome(10));
        System.out.println(new Solution().isPalindrome(1));
        System.out.println(new Solution().isPalindrome(11));
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(2147483647));
        System.out.println(new Solution().isPalindrome(2147447412));
    }

    @Test
    public void isPalindrome2() {
        System.out.println(new Solution().isPalindrome2(-100));
        System.out.println(new Solution().isPalindrome2(121));
        System.out.println(new Solution().isPalindrome2(2442));
        System.out.println(new Solution().isPalindrome2(111));
        System.out.println(new Solution().isPalindrome2(2222));
        System.out.println(new Solution().isPalindrome2(10));
        System.out.println(new Solution().isPalindrome2(1));
        System.out.println(new Solution().isPalindrome2(11));
        System.out.println(new Solution().isPalindrome2(0));
        System.out.println(new Solution().isPalindrome2(2147483647));
        System.out.println(new Solution().isPalindrome2(2147447412));
    }
}