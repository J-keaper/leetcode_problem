package cn.keaper.p62;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    private List<int[]> cases = Arrays.asList(
            new int[]{3,2},
            new int[]{7,3},
            new int[]{100,4},
            new int[]{100,5},
            new int[]{100,6},
            new int[]{100,7},
            new int[]{100,8}
    );


    @Test
    public void uniquePaths() {
        cases.forEach(c -> System.out.println(solution.uniquePaths(c[0],c[1])));
    }
}