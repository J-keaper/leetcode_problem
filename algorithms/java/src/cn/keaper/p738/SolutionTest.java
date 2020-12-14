package cn.keaper.p738;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    private int[] cases = new int[]{0, 1, 9, 10, 21, 67, 98, 99, 100, 1234, 332, 777666,668841, 999999999, 999999998, 1000000000};

    @Test
    public void monotoneIncreasingDigits() {
        System.out.println(solution.monotoneIncreasingDigits(332));
        for (int num : cases) {
            System.out.println(solution.monotoneIncreasingDigits(num));
        }
    }
}