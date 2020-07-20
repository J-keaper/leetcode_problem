package cn.keaper.p46;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[] {1,2},
            new int[] {1,2,3},
            new int[] {1,2,3,4},
            new int[] {3,4,1}
//            new int[] {1,2,3,4,5,6,7,8,9}
//            new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50},
//            new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99}
    );


    @Test
    public void permute() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.permute(c);
            res.forEach(arr -> {
                arr.forEach(i -> System.out.print(i + " "));
                System.out.println();
            });
            System.out.println("-------");
        });
    }

    @Test
    public void permute2() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.permute2(c);
            res.forEach(arr -> {
                arr.forEach(i -> System.out.print(i + " "));
                System.out.println();
            });
            System.out.println("-------");
        });
    }
}