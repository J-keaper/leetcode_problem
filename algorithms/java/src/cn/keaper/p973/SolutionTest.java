package cn.keaper.p973;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case(new int[][]{{1, 3}, {-2, 2}}, 1),
            new Case(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2),
            new Case(new int[][]{{3, 3}, {3, -2}, {-2, 2}, {-2,-1}, {1,1}, {0,2}, {0,1},{1,0}}, 2)
    );


    @Test
    public void kClosest() {
        cases.forEach(c -> {
            System.out.println(Arrays.deepToString(solution.kClosest(c.points.clone(), c.k)));
            System.out.println(Arrays.deepToString(solution.kClosest1(c.points.clone(), c.k)));
            System.out.println(Arrays.deepToString(solution.kClosest2(c.points.clone(), c.k)));
            System.out.println();
        });
    }



    private static class Case{
        private int[][] points;
        private int k;

        public Case(int[][] points, int k) {
            this.points = points;
            this.k = k;
        }
    }

}