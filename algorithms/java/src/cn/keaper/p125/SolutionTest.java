package cn.keaper.p125;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private static String[] cases = new String[]{
            "",
            "a",
            ",a..  .A,/",
            " ))(a,,b.a..",
            ",.A,BA//ba.,.,",
            "  .  ,  ,",
            "0P",
            "A man, a plan, a canal: Panama",
            "race a car"
    };

    private static Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        Arrays.stream(cases).forEach(o -> System.out.println(solution.isPalindrome(o)));
    }

    @Test
    public void isPalindrome1() {
        Arrays.stream(cases).forEach(o -> System.out.println(solution.isPalindrome1(o)));
    }

    @Test
    public void isPalindrome2() {
        Arrays.stream(cases).forEach(o -> System.out.println(solution.isPalindrome2(o)));
    }

    @Test
    public void isPalindrome3() {
        Arrays.stream(cases).forEach(o -> System.out.println(solution.isPalindrome3(o)));
    }

    @Test
    public void isPalindrome4() {
        Arrays.stream(cases).forEach(o -> System.out.println(solution.isPalindrome4(o)));
    }
}