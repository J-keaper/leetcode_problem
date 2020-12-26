package cn.keaper.p85;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    private List<char[][]> cases = Arrays.asList(
            new char[][]{
                    {'1','0','1','0','0'},
                    {'1','0','1','1','1'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','0'}},
            new char[][]{
                    {'1','0','1','0','0'},
                    {'1','1','1','1','1'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','0'}},
            new char[][]{
                    {'1','0','1','0','0'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','1'},
                    {'1','0','0','1','0'}},

            new char[][]{},
            new char[][]{{'0'}},
            new char[][]{{'1'}},
            new char[][]{{'0','0'}}
    );

    @Test
    public void maximalRectangle() {
        cases.forEach(c -> {
            System.out.println(solution.maximalRectangle(c));
            System.out.println(solution.maximalRectangle1(c));
            System.out.println();
        });
    }
}