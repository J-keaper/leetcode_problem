package cn.keaper.p20;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void isValid() {
        Solution solution = new Solution();
        String[] testList = new String[]{"()","()[]{}","(]","([)]","]}","[[[[[]]]]]()[]{}{{[()]}}","(])"};
        Arrays.stream(testList).forEach(o -> {
            System.out.println(o + "\t\t" + solution.isValid(o));
        });
    }

    @Test
    public void isValid2() {
        Solution solution = new Solution();
        String[] testList = new String[]{"()","()[]{}","(]","([)]","]}","[[[[[]]]]]()[]{}{{[()]}}","(])"};
        Arrays.stream(testList).forEach(o -> {
            System.out.println(o + "\t\t" + solution.isValid2(o));
        });
    }
}