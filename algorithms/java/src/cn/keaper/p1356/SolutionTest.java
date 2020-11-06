package cn.keaper.p1356;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{0,1,2,3,4,5,6,7,8},
            new int[]{1024,512,256,128,64,32,16,8,4,2,1},
            new int[]{10000,10000},
            new int[]{2,3,5,7,11,13,17,19},
            new int[]{10,100,1000,10000}
    );

    @Test
    public void sortByBits() {
        cases.forEach(c -> {
            System.out.println(Arrays.toString(solution.sortByBits(c)));
            System.out.println(Arrays.toString(solution.sortByBits1(c)));
            System.out.println(Arrays.toString(solution.sortByBits2(c)));
            System.out.println();

        });
    }

}