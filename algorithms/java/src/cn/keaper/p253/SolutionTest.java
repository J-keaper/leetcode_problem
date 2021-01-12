package cn.keaper.p253;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<int[][]> cases = Arrays.asList(
            new int[][]{{0,30},{5,10},{15,20}},
            new int[][]{{7,10},{2,4}},
            new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}}
    );

    @Test
    public void minMeetingRooms() {
        cases.forEach(c -> {
            System.out.println(solution.minMeetingRooms(c));
            System.out.println(solution.minMeetingRooms1(c));
            System.out.println();
        });
    }
}