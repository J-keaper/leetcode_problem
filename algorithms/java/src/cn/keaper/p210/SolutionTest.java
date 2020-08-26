package cn.keaper.p210;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
        new Case(2, new int[][]{{1,0}}),
        new Case(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})
    );


    @Test
    public void findOrder() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.findOrder(c.num, c.pre))));
    }

    static class Case{
        int num;
        int [][] pre;

        public Case(int num, int[][] pre) {
            this.num = num;
            this.pre = pre;
        }
    }
}