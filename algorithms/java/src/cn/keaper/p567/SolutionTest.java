package cn.keaper.p567;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "ab","eidbaooo",
            "ab","eidboaoo",
            "","abc",
            "c","abc",
            "abc","abc",
            "abc","q"
    );

    @Test
    public void checkInclusion() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.checkInclusion(cases.get(i),cases.get(i+1)));
        }
    }
}