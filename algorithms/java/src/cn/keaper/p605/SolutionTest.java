package cn.keaper.p605;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,0,0,0,1, 1},
            new int[]{1,0,0,0,1, 2},
            new int[]{0,1,0,0,0,1, 2},
            new int[]{0,0,1,0,0,0,0,1, 2},
            new int[]{0,0,0,1,0,0,0,1, 2},
            new int[]{0,0,0,1,0,0,0,1, 3}
    );

    @Test
    public void canPlaceFlowers() {
        cases.forEach(c -> System.out.println(
                solution.canPlaceFlowers(Arrays.copyOf(c, c.length - 1), c[c.length - 1])
        ));

    }

}