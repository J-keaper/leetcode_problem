package cn.keaper.p258;

import org.junit.Test;

public class SolutionTest {

    private int[] cases = new int[]{38,23,3,45,55,654,765,43,2,32,1234,100};

    private Solution solution = new Solution();

    @Test
    public void addDigits() {
        for (int c : cases) {
            System.out.println(c + " -> " + solution.addDigits(c));
        }
    }
}