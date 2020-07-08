package cn.keaper.p412;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void fizzBuzz() {
        List<String> res = solution.fizzBuzz(15);
        res.forEach(System.out::println);
    }
}