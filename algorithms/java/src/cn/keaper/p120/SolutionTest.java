package cn.keaper.p120;

import org.junit.Test;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{
                    {2},
                    {3,4},
                    {6,5,7},
                    {4,1,8,3}
            },
            new int[][]{
                    {1}
            },
            new int[][]{
                    {1},
                    {1,2}
            }
    );

    @Test
    public void minimumTotal() {
        cases.forEach(c -> {
            List<List<Integer>> param = new ArrayList<>();
            for (int[] ints : c) {
                List<Integer> one = new ArrayList<>();
                for (int anInt : ints) {
                    one.add(anInt);
                }
                param.add(one);
            }
            System.out.println(solution.minimumTotal(param));
        });

    }
}