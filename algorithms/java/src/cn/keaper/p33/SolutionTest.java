package cn.keaper.p33;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{4,5,6,7,8,9,1,2,3, 6}, // 2
            new int[]{4,5,6,7,8,9,1,2,3, 9}, // 5
            new int[]{4,5,6,7,8,9,1,2,3, 1}, // 6
            new int[]{4,5,6,7,8,9,1,2,3, 2}, // 7
            new int[]{7,8,9,1,2,3,4,5,6, 4}, // 6
            new int[]{7,8,9,1,2,3,4,5,6, 6}, // 8
            new int[]{7,8,9,1,2,3,4,5,6, 7}, // 0
            new int[]{7,8,9,1,2,3,4,5,6, 9}, // 2
            new int[]{  2}, // -1
            new int[]{2, 2}, // 0
            new int[]{1, 2},  // -1
            new int[]{1,2, 2}, // 1
            new int[]{2,3, 2}  //0
    );

    @Test
    public void search() {
        cases.forEach(c -> System.out.println(solution.search(
                Arrays.copyOf(c,c.length-1),c[c.length-1]
        )));
    }
}