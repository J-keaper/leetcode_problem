package cn.keaper.p367;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Integer> cases = Arrays.asList(0,1,4,10,16,20,25,18,64,225,256,100,121,625,369,2147395600,2147483647);

    private Solution solution = new Solution();

    @Test
    public void isPerfectSquare() {
        cases.forEach(c -> System.out.println(c + " -> " + solution.isPerfectSquare(c)));
    }
}