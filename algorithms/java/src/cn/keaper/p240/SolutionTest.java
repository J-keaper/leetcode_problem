package cn.keaper.p240;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private int[][] matrix = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };


    @Test
    public void searchMatrix() {
        IntStream.range(0,35).forEach(i -> System.out.println(i + " -> " + solution.searchMatrix(matrix, i)));
    }
}