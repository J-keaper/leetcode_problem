package cn.keaper.p67;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void addBinary() {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("",""));
        System.out.println(solution.addBinary("10",""));
        System.out.println(solution.addBinary("","10"));
        System.out.println(solution.addBinary("0","0"));
        System.out.println(solution.addBinary("11","1"));
        System.out.println(solution.addBinary("1010","1011"));
        System.out.println(solution.addBinary("1","11111"));
        System.out.println(solution.addBinary("11111","1"));
        System.out.println(solution.addBinary("0","11111"));
        System.out.println(solution.addBinary("11111","0"));
        System.out.println(solution.addBinary("1010","1"));
        System.out.println(solution.addBinary("1011","1"));
        System.out.println(solution.addBinary("100","1"));
        System.out.println(solution.addBinary("1","1"));
        System.out.println(solution.addBinary("11","11"));
        System.out.println(solution.addBinary("111","111"));
    }
}