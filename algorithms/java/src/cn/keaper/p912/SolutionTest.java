package cn.keaper.p912;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{6,9,8,7,4,5,1,3,2},
            new int[]{1,2,3,4,5,6,7,8,9},
            new int[]{9,8,7,6,5,4,3,2,1}
            );

    @Test
    public void bubbleSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.bubbleSort(c))));
    }

    @Test
    public void selectSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.selectSort(c))));
    }

    @Test
    public void insertSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.insertSort(c))));
    }

    @Test
    public void quickSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.quickSort(c))));
    }

    @Test
    public void mergerSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.mergeSort(c))));
    }

    @Test
    public void heapSort() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.heapSort(c))));
    }
}