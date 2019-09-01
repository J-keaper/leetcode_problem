package cn.keaper.p278;


import org.junit.Test;

import java.util.stream.IntStream;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void firstBadVersion() {
        IntStream.range(1,51).forEach(i -> {
            solution.setBadVersion(i);
            System.out.println(i == solution.firstBadVersion(50));
        });
    }
}