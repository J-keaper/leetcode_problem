package cn.keaper.p1424;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}},
            new int[][]{{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}},
            new int[][]{{1,2,3},{4},{5,6,7},{8},{9,10,11}},
            new int[][]{{1,2,3,4,5,6}}
            );

    @Test
    public void findDiagonalOrder() {
        cases.forEach(c -> {
            List<List<Integer>> param =
                    Arrays.stream(c).map(a -> Arrays.stream(a).boxed().collect(Collectors.toList())).collect(Collectors.toList());
            System.out.println(Arrays.toString(solution.findDiagonalOrder(param)));
        });


    }
}