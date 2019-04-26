package cn.keaper.p14;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void longestCommonPrefix() {
        Solution solution = new Solution();
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{"dog","dog1","dog2"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{};
        System.out.println(solution.longestCommonPrefix(strings));
    }
}