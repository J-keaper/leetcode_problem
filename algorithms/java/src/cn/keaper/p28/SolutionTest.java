package cn.keaper.p28;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void strStr() {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello","hello"));
        System.out.println(solution.strStr("aaaaa","bba"));
        System.out.println(solution.strStr("aaaaa","a"));
        System.out.println(solution.strStr("aaaaa","aaa"));
        System.out.println(solution.strStr("aaaaab","b"));
    }
}