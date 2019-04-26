package cn.keaper.p7;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void reverse() {
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(4548484));
        System.out.println(new Solution().reverse(-454848484));
        System.out.println(new Solution().reverse(2147483647));
        System.out.println(new Solution().reverse(2147483641));
        System.out.println(new Solution().reverse(-2147483648));
        System.out.println(new Solution().reverse(-2147483641));
    }
}