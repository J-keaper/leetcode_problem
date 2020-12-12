package cn.keaper.p252;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{0,30},{5,10},{15,20}},
            new int[][]{{7,10},{2,4}}
    );

    @Test
    public void canAttendMeetings() {
        cases.forEach(c -> System.out.println(
                solution.canAttendMeetings(c)
        ));
    }
}