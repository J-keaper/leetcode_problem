package cn.keaper.p1207;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            IntStream.range(-1000, 1001).toArray(),
            new int[]{1,2,2,1,1,3},
            new int[]{1,2},
            new int[]{-3,0,1,-3,1,1,1,-3,10,0}
    );

    @Test
    public void uniqueOccurrences() {
        cases.forEach(c -> System.out.println(solution.uniqueOccurrences(c)));

        int[] c = new int[2001];
        Arrays.fill(c, 1000);
        System.out.println(solution.uniqueOccurrences(c));
        Arrays.fill(c, -1000);
        System.out.println(solution.uniqueOccurrences(c));
    }
}