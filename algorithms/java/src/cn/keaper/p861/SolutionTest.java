package cn.keaper.p861;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    private List<int[][]> cases = Arrays.asList(
            new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}},
            new int[][]{{0,0,1,1}},
            new int[][]{{0},{0},{1},{1}}
    );

    @Test
    public void matrixScore() {
        cases.forEach(c -> System.out.println(solution.matrixScore(c)));

    }
}