package cn.keaper.p1030;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,0,0},
            new int[]{2,2,0,1},
            new int[]{2,3,1,2}

    );

    @Test
    public void allCellsDistOrder() {
        cases.forEach(c -> System.out.println(Arrays.deepToString(solution.allCellsDistOrder(c[0],c[1],c[2],c[3]))));
    }
}