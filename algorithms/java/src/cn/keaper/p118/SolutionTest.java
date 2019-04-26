package cn.keaper.p118;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void generate() {
        Solution solution = new Solution();
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(2));
        System.out.println(solution.generate(3));
        System.out.println(solution.generate(4));
        System.out.println(solution.generate(5));
        System.out.println(solution.generate(6));
    }
}